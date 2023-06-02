package decorator;

public class BasicSolution {
    public static void deliver(Package aPackage) {
        System.out.println("Delivering package "+ aPackage);
    }

    static void verifyWithOtp(){
        System.out.println("Verifying with OTP");
    }

    interface Package{
        void deliver();
    }

    static class SimplePackage implements Package{
        public void deliver(){
            BasicSolution.deliver(this);
        }

    }

    static class CostlyPackage implements Package{
        public void deliver(){
            BasicSolution.verifyWithOtp();
            BasicSolution.deliver(this);
        }

    }

    public static void main(String[] args) {
        Package simplePackage = new SimplePackage();
        simplePackage.deliver();

        Package costlyPackage = new CostlyPackage();
        costlyPackage.deliver();
    }

}
