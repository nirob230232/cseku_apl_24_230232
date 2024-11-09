package hotel.management230232;
import java.util.*;


// Implementation of Nagat payment method
class NagatPayment implements PaymentMethod {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(Customer customer, double amount) {
        System.out.print("Enter Your Nagat Account Number: ");
        String nagatNumber = scanner.nextLine();
        System.out.print("Enter Your Password: ");
        String password = scanner.nextLine();
        System.out.println("Payment of " + amount + " via Nagat is processed.");
    }
}
