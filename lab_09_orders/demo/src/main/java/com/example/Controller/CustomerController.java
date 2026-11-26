package Controller;

import java.util.List;

import Model.Customer;
import Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customerInfo) {
        return customerService.createCustomer(customerInfo);
    }

    @DeleteMapping("/customers/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public boolean updateCustomer(@PathVariable int id, @RequestBody Customer newCustomerData) {
        return customerService.updateCustomer(id, newCustomerData);
    }
}