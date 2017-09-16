package org.banking.mappers;

import org.banking.dto.CustomerDTO;
import org.banking.peoples.Customer;

public interface CustomerMapper {

    Customer fromDtoToCustomer(CustomerDTO customerDTO);

    org.banking.entity.Customer fromDtoToCustomerEntity(CustomerDTO customerDTO);
}
