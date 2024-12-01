package controller;
import model.*;                    
import payment.PaymentStrategy;     
import view.*;                     
import java.util.Scanner;

/**
 * The HotelController class acts as the Controller in the MVC architecture.
 * It manages the interaction between the Model (Hotel) and the View (HotelView).
 * The Controller handles user inputs, processes requests, and updates the view.
 */

public class HotelController {
    private final Hotel hotel;              
    private final HotelView view;          
 
    /**
     * Constructor to initialize the Controller with the Model and View.
     *
     * @param hotel The Hotel object representing the model.
     * @param view  The HotelView object representing the view.
     */
    
    public HotelController(Hotel hotel, HotelView view) {
        this.hotel = hotel;
        this.view = view;
    }

    /**
     * Starts the application by displaying the main menu and handling user choices.
     * This method serves as the primary loop of the program.
     */
    
    public void start() {
        int choice;                       
        do {
           
            choice = view.showMainMenu();
            switch (choice) {
                case 1:
             
                    Customer customer = view.collectCustomerData(); 
                    int roomType = view.selectRoomType(); 
                    hotel.bookRoom(customer, roomType); 
                    break;

                case 2:
                   
                    hotel.displayAvailableRooms(); 
                    break;

                case 3:
                 
                    hotel.showMenu();
                    break;

                case 4:
                   
                    System.out.print("Enter Customer ID for Payment: ");
                    int customerId = new Scanner(System.in).nextInt(); 
                    hotel.makePayment(customerId, view); 
                    break;

                case 5:
                
                    hotel.displayRecords(); 
                    break;

                case 0:
                    // Case for exiting the system:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    // Handle invalid choices:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0); 
    }
}
