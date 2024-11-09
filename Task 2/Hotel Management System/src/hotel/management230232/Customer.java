
package hotel.management230232;

// SRP: Customer class only handles customer information.

class Customer {
        private static int idCounter = 1; // Static counter to assign unique ID to each customer
    private final int id;               // Unique ID for the customer
    private final String name;          // Name of the customer
    private final String phone;         // Phone number of the customer
    private final String email;         // Email address of the customer
    private final String address;       // Address of the customer
    private final String checkInDate;   // Check-in date for the customer
    private final String checkOutDate;  // Check-out date for the customer
    private Room bookedRoom;            // Room assigned to the customer

    public Customer(String name, String phone, String email, String address, String checkInDate, String checkOutDate) {
        this.id = idCounter++;   // Assign unique ID and increment counter
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
   // Getters for customer details
    public static int getIdCounter() { 
        return idCounter;
    }

    public String getEmail() {
        return email; 
    }

    public String getAddress() {
        return address;
    }

    // Getters for customer details
    public Room getBookedRoom() {
        return bookedRoom;
    }

 
   // Set room for the customer
    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

   // Provides a formatted string with customer and room details
    @Override
    public String toString() {
        return String.format("| %-10s | %-12s | %-20s | %-10s | %-10s | %-15s | %-8.2f |",
                name, phone, address, checkInDate, checkOutDate,
                bookedRoom != null ? bookedRoom.getRoomType() : "N/A",
                bookedRoom != null ? bookedRoom.getPrice() : 0);
    }
}