package template;

public class BetterSolution {

    class Bank {
        final BankService bankService;

        Bank(BankService bankService) {
            this.bankService = bankService;
        }

        void process(OnlineRequest onlineActivity){
            onlineActivity.auth();
            onlineActivity.validate();
            onlineActivity.execute();
        }

    }

    interface OnlineRequest {
        void auth();

        void validate();

        void execute();

    }

    static class FundTransfer implements OnlineRequest {
        final BankService bankService;
        final double amount;
        final Account from, to;
        final double DAILY_TRANSFER_LIMIT = 10_000;

        FundTransfer(BankService bankService, Account from, Account to, double amount) {
            this.bankService = bankService;
            this.amount = amount;
            this.from = from;
            this.to = to;
        }

        @Override
        public void auth() {
            bankService.authWithOtp();
        }

        @Override
        public void validate() {
            if (amount > DAILY_TRANSFER_LIMIT) {
                throw new RuntimeException("amount greater than daily limit");
            }
            if (from.balance() < amount) {
                throw new RuntimeException("not enough balance");
            }
        }

        @Override
        public void execute() {
            bankService.transfer(from, to, amount);
        }
    }

    static class BillPaymment implements OnlineRequest {
        final BankService bankService;
        final Bill bill;
        final Account payee;

        BillPaymment(BankService bankService, Bill bill, Account payee) {
            this.bankService = bankService;
            this.bill = bill;
            this.payee = payee;
        }

        @Override
        public void auth() {
            bankService.authWithOtp();
        }

        @Override
        public void validate() {
            if (payee.balance() < bill.amount()){
                throw new RuntimeException("not enough balance");
            }
        }

        @Override
        public void execute() {
            bankService.transfer(payee, bill.biller(), bill.amount());
        }
    }

    static class BalanceCheck implements OnlineRequest{
        final BankService bankService;
        final Account account;

        BalanceCheck(BankService bankService, Account account) {
            this.bankService = bankService;
            this.account = account;
        }

        @Override
        public void auth() {
            bankService.authWithPin();
        }

        @Override
        public void validate() {

        }

        @Override
        public void execute() {
            bankService.fetchBalanceOf(account);
        }
    }
}
