package payment;

/**
 * The PaymentStrategy interface represents the payment processing behavior 
 * in the system. It is part of the Model layer in the MVC architecture.
 * 
 * This interface follows the Strategy design pattern, allowing the system 
 * to support multiple payment methods without modifying existing code.
 * Each payment method ( Bkash, Nagad, Card  etc.) should implement this interface.
 */

public interface PaymentStrategy {
    
    
    void pay(double amount);
}
