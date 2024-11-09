package hotel.management230232;
import java.util.*;

// Implementation of credit/debit card payment method
class CreditDebitCardPayment implements PaymentMethod {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(Customer customer, double amount) {
        System.out.print("Enter Your Debit/Credit Card ID: ");
        String cardId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Payment of " + amount + " via Credit/Debit Card is processed.");
    }
}
