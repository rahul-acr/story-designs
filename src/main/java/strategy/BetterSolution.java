package strategy;

public class BetterSolution {
    interface PaymentStrategy{
        void pay(double amount);
    }

    class Payment{
        final PaymentStrategy paymentStrategy;
        final double amount;

        Payment(PaymentStrategy paymentStrategy, double amount) {
            this.paymentStrategy = paymentStrategy;
            this.amount = amount;
        }

        void pay(){
            paymentStrategy.pay(amount);
        }
    }

    static class CreditCardPaymentStrategy implements PaymentStrategy{

        @Override
        public void pay(double amount) {
            System.out.println("Paying via credit card");
        }
    }

    static class UpiPaymentStrategy implements PaymentStrategy{

        @Override
        public void pay(double amount) {
            System.out.println("Paying via UPI");
        }
    }
}
