package template;

public class BasicExample {

    class Bank {

        private static final double DAILY_TRANSFER_LIMIT = 10_000;
        final BankService bankService;

        Bank(BankService bankService) {
            this.bankService = bankService;
        }

        void fundTransfer(Account from, Account to, double amount) {
            bankService.authWithOtp();
            if( amount > DAILY_TRANSFER_LIMIT){
                throw new RuntimeException("amount greater than daily limit");
            }
            if (from.balance() < amount){
                throw new RuntimeException("not enough balance");
            }
            bankService.transfer(from, to, amount);
        }

        void payBill(Account from, Bill bill){
            bankService.authWithOtp();
            if (from.balance() < bill.amount()){
                throw new RuntimeException("not enough balance");
            }
            bankService.transfer(from, bill.biller(), bill.amount());
        }

        void checkBalance(Account account){
            bankService.authWithPin();
            bankService.fetchBalanceOf(account);
        }
    }


}
