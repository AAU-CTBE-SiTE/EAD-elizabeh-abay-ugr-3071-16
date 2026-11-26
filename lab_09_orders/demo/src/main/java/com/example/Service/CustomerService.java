package Service;

import Model.Customer;
import Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElseGet(Customer::new);
    }

    public Customer createCustomer(Customer customerInfo) {
        return customerRepository.save(customerInfo);
    }

    public boolean deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateCustomer(int id, Customer newCustomerData) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(newCustomerData.getName());
            customer.setEmail(newCustomerData.getEmail());
            customerRepository.save(customer);
            return true;
        }
        return false;
    }
}