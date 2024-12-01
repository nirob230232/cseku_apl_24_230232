package model;
import java.util.*;

/**
 * The Customer class represents the Model in the MVC architecture.
 * It encapsulates the data and behavior of a customer, such as personal details,
 * booking information, and associated room details.
 */

public class Customer {
    private final Scanner scanner = new Scanner(System.in); 
    private static int idCounter = 0; 
  
    private final String name; 
    private final String phone;
    private final String email; 
    private final String address; 
    private final String checkInDate; 
    private final String checkOutDate; 
    private Room bookedRoom; 

    /**
     * Constructs a Customer object with the provided details.
     * Automatically assigns a unique ID to the customer.
     *
     * @param name        The customer's name.
     * @param phone       The customer's phone number.
     * @param email       The customer's email address.
     * @param address     The customer's address.
     * @param checkInDate The customer's check-in date.
     * @param checkOutDate The customer's check-out date.
     */
    
    
    public Customer(String name, String phone, String email, String address, String checkInDate, String checkOutDate) {
        this.idCounter = ++idCounter; 
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

   
    public static int getId() {
        return idCounter;
    }

 
    public String getName() {
        return name;
    }

  
    public Room getBookedRoom() {
        return bookedRoom;
    }


    public void setBookedRoom(Room room) {
        this.bookedRoom = room;
    }

    
    /**
     * Returns a formatted string representing the customer's details.
     *
     * @return A string containing customer details in tabular format.
     */
    
    
    @Override
    public String toString() {
        return String.format(
            "| %-10s | %-12s | %-20s | %-10s | %-10s | %-15s | %-8.2f |",
            name, phone, address, checkInDate, checkOutDate,
            bookedRoom != null ? bookedRoom.getRoomType() : "N/A", // Room type or "N/A" if not booked.
            bookedRoom != null ? bookedRoom.getPrice() : 0 // Room price or 0 if not booked.
        );
    }
}
