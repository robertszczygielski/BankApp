package org.banking.mappers.impl;

import org.banking.dto.CustomerDTO;
import org.banking.mappers.CustomerMapper;
import org.banking.peoples.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer fromDtoToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setPesel(customerDTO.getPesel());

        return customer;
    }
}
