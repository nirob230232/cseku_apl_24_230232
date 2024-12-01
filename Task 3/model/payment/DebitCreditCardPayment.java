package payment;

/**
 * The DebitCreditCardPayment class implements the PaymentStrategy interface 
 * to handle payments through debit or credit cards. 
 * It is part of the Model layer in the MVC architecture.
 */


public class DebitCreditCardPayment implements PaymentStrategy {
    private final String DebitorCreditCardID; 


    public DebitCreditCardPayment(String IDNumber) {
        this.DebitorCreditCardID = IDNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of " + amount + " via Credit/Debit Card is processed.");
    }
}

