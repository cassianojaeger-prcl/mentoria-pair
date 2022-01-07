package projeto.mentoria.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import projeto.mentoria.demo.model.Customer;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerRepositoryTest {

  @Autowired
  CustomerRepository customerRepository;

  /**
   * This method is triggered before each test execution
   * Usually we add essential mock data for all tests
   */
  @BeforeEach
  void setUp() {}

  /**
   * We have several naming conventions for tests. I personally prefer
   * CamelCase with Given_When_Then approach.
   */
  @Test
  void GivenSomething_WhenDoingSomething_ThenSomethingHappen() {}

  /**
   * Another approach is to use simple camelCase and adding given, when, then
   * clauses as comments inside the method. It is really up to you.
   * https://medium.com/@stefanovskyi/unit-test-naming-conventions-dd9208eadbea this article
   * shows some other conventions.
   */
  @Test
  void shouldReturnSomethingWhenDoingSomething() {
    //Given
    //When
    //Then
  }

  @Test
  void GivenAValidCustomer_WhenSaving_ThenCustomerMustExistInDb() {
    //Given Customer
    Customer customer = new Customer(5L, "test", "lastNametest", 20);

    //When saving
    customerRepository.saveCustomer(customer);

    //Then Customer must exist
    Assertions.assertEquals(customer, customerRepository.getCustomerById(customer.getId()));
  }

  @Test
  void GivenANullCustomer_WhenSaving_ThenErrorShouldBeExpected() {
    //TODO: IMPLEMENT
  }
}