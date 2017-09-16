package org.banking.services;

import org.banking.entity.Customer;
import org.banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
