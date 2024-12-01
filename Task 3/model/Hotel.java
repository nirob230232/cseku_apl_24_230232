package model;

import payment.PaymentStrategy;
import view.HotelView; 
import java.util.*;

/**
 * The Hotel class serves as the Model in the MVC architecture.
 * It contains the core business logic for managing hotel operations,
 * including room bookings, customer records, payments, and room service.
 */

public class Hotel {

    private final String name; 
    private final List<Room> rooms = new ArrayList<>(); 
    private final List<Customer> customers = new ArrayList<>(); 
    private final Map<String, Double> menu = new HashMap<>(); 

    /**
     * Constructs a Hotel object and initializes rooms and menu.
     *
     * @param name The name of the hotel.
     */
    
    public Hotel(String name) {
        this.name = name;
        initializeRooms(); 
        initializeMenu(); 
    }

    /**
     * Initializes the rooms in the hotel with predefined types, numbers, and prices.
     */
    
    private void initializeRooms() {
        rooms.add(new Room(101, "Standard Non-AC", 3000));
        rooms.add(new Room(102, "Standard AC", 3500));
        rooms.add(new Room(103, "3-Bed Non-AC", 4500));
        rooms.add(new Room(104, "3-Bed AC", 5000));
    }

    /**
     * Initializes the room service menu with predefined items and their prices.
     */
    
    private void initializeMenu() {
        
        menu.put("Sandwich", 150.0);
        menu.put("Pizza", 500.0);
        menu.put("Pasta", 250.0);
        menu.put("Coffee", 100.0);
    }

    /**
     * Handles payment for a customer using their ID and the selected payment method.
     *
     * @param customerId The ID of the customer making the payment.
     * @param view       The HotelView object to handle user interaction for payment selection.
     */
    
    public void makePayment(int customerId, HotelView view) {
        
        for (Customer customer : customers) {
            
            if (customer.getId() == customerId) {
                double amount = customer.getBookedRoom().getPrice();
                PaymentStrategy paymentMethod = view.selectPaymentMethod(); 
                paymentMethod.pay(amount); 
                System.out.println("Payment successful for Customer ID: " + customerId);
                return;
            }
        }
        System.out.println("Invalid Customer ID."); 
        
    }

    /**
     * Books a room for a customer based on their selected room type.
     *
     * @param customer       The customer object containing booking details.
     * @param roomTypeChoice The type of room the customer wants to book.
     */
    
    
    public void bookRoom(Customer customer, int roomTypeChoice) {
        for (Room room : rooms) {
            if (!room.isBooked() && mapRoomTypeToChoice(room.getRoomType()) == roomTypeChoice) {
                room.book(); 
                customer.setBookedRoom(room); 
                customers.add(customer); 
                System.out.println("Room booked successfully! Room No: " + room.getRoomNumber());
                System.out.println("Customer Id – " + Customer.getId());
                return;
            }
        }
        System.out.println("Sorry, no rooms available for this type."); 
    }

    /**
     * Displays all rooms that are currently available for booking.
     */
    
    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room No: " + room.getRoomNumber() + " (" + room.getRoomType() + ") - Price: " + room.getPrice());
            }
        }
    }

    
    /**
     * Displays the records of all customers who have booked rooms.
     */
    
    public void displayRecords() {
        System.out.println("Customer Records:");
        customers.forEach(customer -> System.out.println(customer));

    }

    /**
     * Displays the room service menu with items and their prices.
     */
    
    public void showMenu() {
        System.out.println("Room Service Menu:");
        menu.forEach((item, price) -> System.out.println(item + ": " + price));
    }

    
    
     //Maps room types to menu choices for easier selection.
    
    
    private int mapRoomTypeToChoice(String roomType) {
        return switch (roomType) {
            case "Standard Non-AC" -> 1;
            case "Standard AC" -> 2;
            case "3-Bed Non-AC" -> 3;
            case "3-Bed AC" -> 4;
            default -> 0; // Returns 0 if the room type does not match any predefined type.
        };
    }
}
