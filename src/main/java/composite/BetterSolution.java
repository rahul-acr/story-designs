package composite;

import java.util.ArrayList;
import java.util.List;

public class BetterSolution {
    static class Address{
        String city;

        public Address(String city) {
            this.city = city;
        }
    }

    static class Customer{
        int customerId;
        Address address;
        List<Account> accounts = new ArrayList<>();

        public Customer(int customerId, Address address) {
            this.customerId = customerId;
            this.address = address;
        }

        public void updateAddress(Address newAddress){
            address = newAddress;
            accounts.forEach(account -> updateAddress(newAddress));
        }

        public void addAccount(Account account){
            accounts.add(account);
        }
    }

    static class Account{
        int accountId;
        Address address;


        public Account(int accountId, Address address) {
            this.accountId = accountId;
            this.address = address;
        }

        public void updateAddress(Address newAddress){
            address = newAddress;
        }
    }


    public static void main(String[] args) {
        Address pune  = new Address("Pune");
        Customer customer = new Customer(1, pune);
        Account account = new Account(12, pune);
        customer.addAccount(account);

        Address kolkata  = new Address("Kolkata");
        customer.updateAddress(kolkata);
    }
}
