package payment;

/**
 * The CardPayment class processes payments via card and implements the PaymentStrategy interface.
 * It represents the Model layer in the MVC structure.
 */

public class CardPayment implements PaymentStrategy {
    private final String cardNumber; 
    
    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

   
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card. Card Number: " + cardNumber);
    }
}
