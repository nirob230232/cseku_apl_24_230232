package hotel.management230232;


// Implementation of cash payment method
class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(Customer customer, double amount) {
        System.out.println("Payment of " + amount + " via Cash is processed.");
    }
}
