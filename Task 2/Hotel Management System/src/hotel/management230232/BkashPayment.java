package hotel.management230232;
import java.util.*;

// Implementation of Bkash payment method
class BkashPayment implements PaymentMethod {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(Customer customer, double amount) {
        System.out.print("Enter Your Bkash Account Number: ");
        String bKashNumber = scanner.nextLine();
        System.out.print("Enter Your Password: ");
        String password = scanner.nextLine();
        System.out.println("Payment of " + amount + " via Bkash is processed.");
    }
}