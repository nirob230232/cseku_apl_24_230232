package hotel.management230232;
import java.util.*;

// Main application for Hotel Management System
public class HotelManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Hotel hotel = new Hotel("Hotel Asia");

    public static void main(String[] args) {
        System.out.println("WELCOME TO " + hotel.name);
        int choice;
 do {
            showMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    hotel.displayAvailableRooms();
                    break;
                case 3:
                    hotel.showMenu();
                    break;
                case 4:
                    hotel.makePayment();
                    break;
                case 5:
                    hotel.displayRecords();
                    break;
                case 0:
                    System.out.println("Exiting... Thank you for visiting " + hotel.getName());
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    // Display the main menu
    private static void showMainMenu() {
        System.out.println("\n1. Booking");
        System.out.println("2. Rooms Info");
        System.out.println("3. Room Service (Menu Card)");
        System.out.println("4. Payment");
        System.out.println("5. Record");
        System.out.println("0. Exit");
        System.out.print("Please Enter Your Choice: ");
    }

   // Collect customer data and book room
    private static void bookRoom() {
        System.out.println("****** BOOKING ROOMS ******");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone No: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Check-In (dd/mm/yyyy): ");
        String checkIn = scanner.nextLine();
        System.out.print("Check-Out (dd/mm/yyyy): ");
        String checkOut = scanner.nextLine();

        System.out.println("---SELECT ROOM TYPE---" + '\n');
        System.out.println("1. Standard Non-AC\n2. Standard AC\n3. 3-Bed Non-AC\n4. 3-Bed AC");
        System.out.print("Please Enter Your Choice: ");
        int roomTypeChoice = scanner.nextInt();
        
        Customer customer = new Customer(name, phone, email, address, checkIn, checkOut);
        hotel.bookRoom(customer, roomTypeChoice);
        
    }

}
