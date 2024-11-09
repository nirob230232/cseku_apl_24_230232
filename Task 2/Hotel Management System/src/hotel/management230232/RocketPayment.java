package hotel.management230232;
import java.util.*;


// Implementation of Rocket payment method
class RocketPayment implements PaymentMethod {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void processPayment(Customer customer, double amount) {
        System.out.print("Enter Your Rocket Account Number: ");
        String rocketNumber = scanner.nextLine();
        System.out.print("Enter Your Password: ");
        String password = scanner.nextLine();
        System.out.println("Payment of " + amount + " via Rocket is processed.");
    }
}
