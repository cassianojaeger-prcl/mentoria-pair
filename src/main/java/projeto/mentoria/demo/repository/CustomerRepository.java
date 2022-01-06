package projeto.mentoria.demo.repository;

import org.springframework.stereotype.Component;
import projeto.mentoria.demo.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerRepository {

  private final List<Customer> inMemoryDb;

  public CustomerRepository() {
    this.inMemoryDb = new ArrayList<>();
//    this.populateDatabase();
  }

  public List<Customer> getAllCustomers() {
    return inMemoryDb;
  }

  public Customer saveCustomer(Customer customer) {
    inMemoryDb.add(customer);
    return customer;
  }

  public Customer getCustomerById(long id) {
    return inMemoryDb.stream().filter(cust -> cust.getId() == id).findFirst().orElse(null);
  }

  public List<Customer> getCustomersByAge(int age) {
    return inMemoryDb.stream().filter(cust -> cust.getAge() == age).collect(Collectors.toList());
  }
//
//  private void populateDatabase() {
//    this.inMemoryDb.add(new Customer(1L,"john1", "palma1", 10));
//    this.inMemoryDb.add(new Customer(2L,"john2", "palma2", 20));
//    this.inMemoryDb.add(new Customer(3L,"john3", "palma3", 30));
//  }
}
