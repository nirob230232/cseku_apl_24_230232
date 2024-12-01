package payment;

/**
 * The BkashPayment class implements the PaymentStrategy interface 
 * This class is part of the Model layer in the MVC architecture, encapsulating
 * the behavior for processing payments via Bkash.
 */


public class BkashPayment implements PaymentStrategy {

    private final String bkashNumber; 
    
    public BkashPayment(String bkashNumber) {
        this.bkashNumber = bkashNumber;
    }


    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Bkash. Number: " + bkashNumber);
    }
}
