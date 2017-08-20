package org.banking.peoples;

import org.banking.accounts.Account;

import java.io.Serializable;

public class Customer implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String pesel;
    private Account account;

    private static int globalId = 100;

    public Customer() {
        this.id = globalId++;
    }

    public Customer(String firstName, String lastName, String pesel) {
        this.id = globalId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return (firstName != null ? firstName.equals(customer.firstName) : customer.firstName == null)
                && (lastName != null ? lastName.equals(customer.lastName) : customer.lastName == null)
                && (pesel != null ? pesel.equals(customer.pesel) : customer.pesel == null)
                && (account != null ? account.equals(customer.account) : customer.account == null);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
