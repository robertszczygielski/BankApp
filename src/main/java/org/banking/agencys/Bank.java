package org.banking.agencys;

import org.banking.peoples.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private List<Customer> customers;
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public List<Customer> getCustomers() {
        return customers != null ? customers : Collections.emptyList();
    }

    public void setCustomers(List<Customer> customers) {
        if (this.customers == null) {
            this.customers = customers;
        } else {
            this.customers.addAll(customers);
        }
    }

    public void setCustomer(Customer customer) {
        if (this.customers == null) {
            this.customers = new ArrayList<>();
        }
        this.customers.add(customer);
    }
}
