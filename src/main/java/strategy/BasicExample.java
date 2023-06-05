package strategy;

public class BasicExample {
    class PaymentProcessor{
        void process(PaymentMethod paymentMethod, double amount){
            switch (paymentMethod){
                case CREDIT_CARD -> processCreditCardPayment(amount);
                case DEBIT_CARD -> processDebitCardPayment(amount);
                case UPI -> processUpiPayment(amount);
            }
        }
    }

    private static void processUpiPayment(double amount) {
        System.out.println("Paying via UPI "+ amount);
    }

    private static void processDebitCardPayment(double amount) {
        System.out.println("Paying via debit card "+ amount);
    }

    private static void processCreditCardPayment(double amount) {
        System.out.println("Paying via credit card "+ amount);
    }
}
