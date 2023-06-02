package strategy;

public class BasicExample {
    class PaymentProcessor{
        void process(PaymentMethod paymentMethod, double amount){
            switch (paymentMethod){
                case CREDIT_CARD -> System.out.println("Paying via credit card");
                case DEBIT_CARD -> System.out.println("Paying via debit card");
                case UPI -> System.out.println("Paying via UPI");
            }
        }
    }
}
