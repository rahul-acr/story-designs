package decorator;

public class BetterSolution {

    public static void deliver(Package aPackage) {
        System.out.println("Delivering package "+ aPackage);
    }

    static void verifyWithOtp(){
        System.out.println("Verifying with OTP");
    }

    interface Package{
        void deliver();
    }

    static class SimplePackage implements Package {
        public void deliver(){
            BetterSolution.deliver(this);
        }

    }

    static class CostlyPackage implements Package{

        final Package aPackage;

        CostlyPackage(Package aPackage) {
            this.aPackage = aPackage;
        }

        @Override
        public void deliver() {
            BetterSolution.verifyWithOtp();
            aPackage.deliver();
        }
    }

    public static void main(String[] args) {
        Package simplePackage = new SimplePackage();
        simplePackage.deliver();

        Package costlyPackage = new CostlyPackage(new SimplePackage());
        costlyPackage.deliver();
    }
}
