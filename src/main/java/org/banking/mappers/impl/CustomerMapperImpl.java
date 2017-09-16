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

    @Override
    public org.banking.entity.Customer fromDtoToCustomerEntity(CustomerDTO customerDTO) {
        org.banking.entity.Customer customer = new org.banking.entity.Customer(customerDTO.getFirstName(),
                customerDTO.getLastName());

        return customer;
    }
}
