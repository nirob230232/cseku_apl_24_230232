package model;

/**
 * The Room class represents the Model in the MVC architecture.
 * It encapsulates the data and behavior of a hotel room, including details such as
 * room number, type, price, and its booking status.
 */

public class Room {
    private final int roomNumber; 
    private final String roomType; 
    private final double price; 
    private boolean isBooked; 

    /**
     * Constructs a Room object with the specified details.
     *
     * @param roomNumber The unique room number.
     * @param roomType   The type of the room.
     * @param price      The price of the room.
     */
    
    
    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = false; 
    }

   
    public int getRoomNumber() {
        return roomNumber;
    }

    
    public String getRoomType() {
        return roomType;
    }

  
    public double getPrice() {
        return price;
    }

   
    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        this.isBooked = true;
    }

   
    public void checkout() {
        this.isBooked = false;
    }
}
