package projeto.mentoria.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import projeto.mentoria.demo.model.Customer;
import projeto.mentoria.demo.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIntegrationTest {

  /**
   * When doing a controller end-to-end test, it is necessary to make http calls.
   * RestTemplate is how we can perform it on Java. There is several ways of doing it, but
   * RestTemplate is one of the less verbose ones.
   */
  @Autowired
  public TestRestTemplate restTemplate;
  @Autowired
  public CustomerRepository customerRepository;

  @BeforeEach
  void setUp() {

  }

  /**
   * As we are handling with integration tests, we need to insert data before testing.
   * In that case, we are adding customer directly to the database by doing a repository method call
   * After that we perform our api call and then make the test assertions to verify if the operation
   * was successful.
   *
   * First it is interesting to verify if the response code was the expected one {@link HttpStatus}
   * Later we must verify if the retrieved object is the expected one. Java allow is to define how to
   * calculate with a object is equals to the other using {@link Object#equals(Object)} and {@link Object#hashCode()}
   */
  @Test
  void GivenAValidCustomerId_WhenGettingCustomerById_ThenReturnCustomer() {
    //Given a valid customer
    Customer customer = new Customer(10L, "firstName", "lastName", 30);
    customerRepository.saveCustomer(customer);

    //When getting Customer by Id
    final ResponseEntity<Customer> response =
        restTemplate.getForEntity(
            "/customer/id/" + customer.getId(), Customer.class);

    //Then return customer
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(response.getBody(), customer);
  }

  @Test
  void GivenAInvalidCustomerId_WhenGettingCustomerById_ThenReturnEmptyList() {
    //TODO
  }
}