package projeto.mentoria.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.mentoria.demo.model.CreditCard;
import projeto.mentoria.demo.model.Customer;
import projeto.mentoria.demo.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController("")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customer")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    return ResponseEntity.ok(customerRepository.getAllCustomers());
  }

  @GetMapping("/customer/id/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    return ResponseEntity.ok(customerRepository.getCustomerById(id));
  }

  @GetMapping("/customer/age/{age}")
  public ResponseEntity<List<Customer>> getCustomerByAge(@PathVariable int age) {
    return ResponseEntity.ok(customerRepository.getCustomersByAge(age));
  }

  @PutMapping("/customer")
  public ResponseEntity saveCustomer(@RequestBody Customer customer) {
    if(customer.getAge() < 0) {
      return ResponseEntity.internalServerError().body("Age cannot be less then 0");
    }
    return ResponseEntity.ok(customerRepository.saveCustomer(customer));
  }

  @PutMapping("/credit-card")
  public ResponseEntity saveCreditCardForCustomer(@RequestParam Long customerId, @RequestBody CreditCard creditCard) {
    Customer customer = customerRepository.getCustomerById(customerId);
    if(creditCard.getExpirationYear() < LocalDateTime.now().getYear()) {
      return ResponseEntity.internalServerError().body("Expiration year cannot be less then current year");
    }
    customer.setCreditCards(List.of(creditCard));
    return ResponseEntity.ok(customerRepository.saveCustomer(customer));
  }

  @GetMapping("/credit-card/id/{id}")
  public ResponseEntity getCreditCardByCustomerId(@PathVariable Long id) {
    return ResponseEntity.ok(customerRepository.getCustomerById(id).getCreditCards());
  }
}
