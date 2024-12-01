package payment;

/**
 * The NagadPayment class implements the PaymentStrategy interface to process payments using Nagad.
 * Part of the Model layer in the MVC architecture.
 */


public class NagadPayment implements PaymentStrategy {
    private final String nagadNumber; 

   
    public NagadPayment(String nagadNumber) {
        this.nagadNumber = nagadNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Nagad. Number: " + nagadNumber);
    }
}
