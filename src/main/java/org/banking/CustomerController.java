package org.banking;

import com.google.gson.Gson;
import org.banking.agencys.Bank;
import org.banking.dto.CustomerDTO;
import org.banking.mappers.CustomerMapper;
import org.banking.peoples.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/bank")
public class CustomerController implements ErrorController {

    private final CustomerMapper customerMapper;

    private Bank bank = new Bank("HEHE");

    private static final String PATH = "/error";

    @Autowired
    public CustomerController(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/addCustomer/{id}")
    @ResponseBody
    public String getCustomer(@PathVariable String id) {
        List<Customer> customers = bank.getCustomers();
        Customer customerToSend = null;
        for (Customer customer : customers) {
            if ((Integer.valueOf(id)).equals(customer.getId())) {
                customerToSend = customer;
                System.out.println(customer);
                break;
            }
        }

        Gson gson = new Gson();

        return gson.toJson(customerToSend);
    }

    @PostMapping(value = "/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDtoToCustomer(customerDTO);
        bank.setCustomer(customer);
    }
}
