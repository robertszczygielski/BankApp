package org.banking.peoples;

import org.banking.accounts.Account;
import validators.ValidPesel;

public class Customer {

    private String firstName;
    private String lastName;
    @ValidPesel(regex = "\\d\\d\\d")
    private String PESEL;
    private Account account;

    public Customer(String firstName, String lastName, String PESEL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", account=" + account +
                '}';
    }

}
