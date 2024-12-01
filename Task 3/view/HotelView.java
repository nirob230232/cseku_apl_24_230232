package view;
import payment.*;             
import java.util.Scanner;    
import model.Customer;     

/**
 * The HotelView class acts as the View in the MVC architecture.
 * It is responsible for displaying options and collecting input from the user.
 * It serves as the interface between the user and the system.
 */


public class HotelView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays the main menu to the user and collects their choice.
     *
     * @return The user's choice as an integer.
     */
    
    public int showMainMenu() {
        System.out.println("\n1. Booking");
        System.out.println("2. Rooms Info");
        System.out.println("3. Room Service (Menu Card)");
        System.out.println("4. Payment");
        System.out.println("5. Record");
        System.out.println("0. Exit");
        System.out.print("Please Enter Your Choice: ");
        return scanner.nextInt();       
    }

    /**
     * Displays room type options and collects the user's selection.
     *
     * @return The user's selected room type as an integer.
     */
    
    
    public int selectRoomType() {
        System.out.println("---SELECT ROOM TYPE---\n");
        System.out.println("1. Standard Non-AC");
        System.out.println("2. Standard AC");
        System.out.println("3. 3-Bed Non-AC");
        System.out.println("4. 3-Bed AC");
        System.out.print("Please Enter Your Choice: ");
        return scanner.nextInt();
    }

    /**
     * Collects customer information from the user.
     *
     * @return A Customer object populated with user-provided data.
     */
    
    
    public Customer collectCustomerData() {
        scanner.nextLine(); // Clear the buffer.
        System.out.println("****** BOOKING ROOMS ******");
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Check-In (dd/mm/yyyy): ");
        String checkIn = scanner.nextLine();
        System.out.print("Check-Out (dd/mm/yyyy): ");
        String checkOut = scanner.nextLine();
        return new Customer(name, phoneNumber, email, address, checkIn, checkOut);
    }

    /**
     * Displays payment method options and collects the user's selection.
     *
     * @return A PaymentStrategy object corresponding to the selected method.
     */
    
    
    public PaymentStrategy selectPaymentMethod() {
        System.out.println("Select Payment Method:");
        System.out.println("1. Bkash");
        System.out.println("2. Nagad");
        System.out.println("3. Card");
        System.out.println("4. Credit/Debit Card");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter Bkash Number: ");
                return new BkashPayment(scanner.nextLine());

            case 2:
                System.out.print("Enter Nagad Number: ");
                return new NagadPayment(scanner.nextLine());

            case 3:
                System.out.print("Enter Card Number: ");
                return new CardPayment(scanner.nextLine());

            case 4:
                System.out.print("Enter Your Debit/Credit Card ID: ");
                return new DebitCreditCardPayment(scanner.nextLine());

            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
    }
}
