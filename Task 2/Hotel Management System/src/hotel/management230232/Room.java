
package hotel.management230232;

 // SRP: Room class is focused on room details and booking status.
 // Represents a room in the hotel
class Room {
    private final int roomNumber;       // Room number
    private final String roomType;      // Type of the room (e.g., Standard, AC)
    private final double price;         // Price of the room per night
    private boolean isBooked;           // Room booking status

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = false;
    }

   // Getters for room details
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

   // Mark room as booked
    public void book() { 
        isBooked = true;
    }
    
   // Mark room as available after checkout
    public void checkout() {
        isBooked = false; 
    }
}

