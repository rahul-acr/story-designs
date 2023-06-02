package composite;

import java.util.Collections;
import java.util.List;

public class BasicExample {

    static class Address{
        String city;
    }

    static class Customer{
        int customerId;
        Address address;
    }

    static class Account{
        int customerId;
        int accountId;
        Address address;

    }

    class CustomerService{

        void updateAddress(int customerId, Address newAddress){
            Customer customer = findCustomerById(customerId);
            customer.address = newAddress;
            List<Account> accounts = findAccountsByCustomerId(customerId);
            accounts.forEach(account -> account.address = newAddress);
        }

        private List<Account> findAccountsByCustomerId(int customerId) {
            // to be replaced by repo call
            return Collections.emptyList();
        }


        private Customer findCustomerById(int customerId) {
            // to be replaced by repo call
            return new Customer();
        }


    }

}
