package hotel.management230232;
import java.util.*;


//Hotel class implements multiple interfaces to handle separate services, adhering to SRP and ISP.
class Hotel implements BookingService, RecordService, RoomService {
    
    private static final Scanner scanner = new Scanner(System.in);
    public final String name;                                   // Name of the hotel
    private final List<Room> rooms = new ArrayList<>();         // List of rooms in the hotel
    public final List<Customer> customers = new ArrayList<>();  // List of customers
    private final Map<String, Double> menu = new HashMap<>();   // Room service menu

    public Hotel(String name) {
        this.name = name;
        addRooms();          // Initialize room list
        initializeMenu();    // Initialize menu items
    }

    public String getName() {
        return name;
    }
    
    
   // Adds rooms to the hotel
    private void addRooms() {
        rooms.add(new Room(321, "3-Bed Non-AC", 4500));
        rooms.add(new Room(322, "3-Bed AC", 5000));
        rooms.add(new Room(323, "Standard Non-AC", 3000));
        rooms.add(new Room(324, "Standard AC", 3500));
    }

   // Initializes the room service menu
    private void initializeMenu() {
        menu.put("Sandwich", 150.0);
        menu.put("Pizza", 500.0);
        menu.put("Pasta", 250.0);
        menu.put("Coffee", 100.0);
    }

    // SRP: BookingService implementation handles booking functionality separately.
    // Book a room based on room type choice
    @Override
    public void bookRoom(Customer customer, int roomTypeChoice) {
      Room room = null;
      for (Room r : rooms) {
      if (!r.isBooked() && mapRoomTypeToChoice(r.getRoomType()) == roomTypeChoice) {
        room = r;
        break;
        }
      }

        if (room != null) {
            room.book();
            customer.setBookedRoom(room);
            customers.add(customer);
            System.out.println("***ROOM BOOKED SUCCESSFULLY***");
            System.out.println("Room No. – " + room.getRoomNumber());
            System.out.println("Customer Id – " + customer.getIdCounter());
        } else {
            System.out.println("Sorry, the selected room type is not available.");
        }
    }
    
    // Map room type to integer choices for booking
    private int mapRoomTypeToChoice(String roomType) {
        return switch (roomType) {
            case "Standard Non-AC" -> 1;
            case "Standard AC" -> 2;
            case "3-Bed Non-AC" -> 3;
            case "3-Bed AC" -> 4;
            default -> 0;
        };
    }

   // Display available rooms
    @Override
    public void displayAvailableRooms() {
    System.out.println("Available rooms:");
    for (Room room : rooms) {
        if (!room.isBooked()) {
            System.out.println("Room No. " + room.getRoomNumber() + " (" + room.getRoomType() + ") - Price: " + room.getPrice());
        }
    }
   }


    // SRP: RoomService implementation handles room service (menu display).
    // Show room service menu
    @Override
    public void showMenu() {
        System.out.println("Menu Card:");
        menu.forEach((item, price) -> System.out.println(item + ": $" + price));
    }

 

    // SRP: RecordService implementation handles record display.
     // Display records of all customers
    @Override
    public void displayRecords() {
        System.out.println("*** HOTEL RECORDS ***");
        System.out.println("| Name       | Phone No.     | Address              | Check-In   | Check-Out  | Room Type      | Price    |");
        System.out.println("--------------------------------------------------------------------------------------------");
        customers.forEach(System.out::println);
    }

// Handle payment for a customer
public void makePayment() {
    

System.out.print("Customer ID: ");
int customerId = scanner.nextInt();
scanner.nextLine();  

Customer customer = null;
for (Customer c : customers) {
    if (c.getIdCounter() == customerId) {
        customer = c;
        break;
    }
}

if (customer != null) {
    double amount = customer.getBookedRoom().getPrice();
    System.out.println("Amount: " + amount);
    System.out.println("MODE OF PAYMENT\n1. Credit/Debit Card\n2. Bkash\n3. Nagat\n4. Rocket\n5. Cash");
    System.out.print("-> ");
    int paymentChoice = scanner.nextInt();
    scanner.nextLine();

    PaymentMethod paymentMethod;
 

        
switch (paymentChoice) {
    case 1:
        paymentMethod = new CreditDebitCardPayment();
        break;
    case 2:
        paymentMethod = new BkashPayment();
        break;
    case 3:
        paymentMethod = new NagatPayment();
        break;
    case 4:
        paymentMethod = new RocketPayment();
        break;
    case 5:
        paymentMethod = new CashPayment();
        break;
    default:
        System.out.println("Invalid payment choice.");
        return;
}
            paymentMethod.processPayment(customer, amount);
       
    } else {
        System.out.println("Invalid Customer ID.");
    }
}

}

