package projeto.mentoria.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import projeto.mentoria.demo.model.Customer;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryTest {

  /**
   * JUnit Specific to unit test something with mocks. This annotation will inject
   * all dependencies defined mocks into this class. In our case, we still don't have anything.
   */
  @InjectMocks
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

  /**
   * Unit tests are designed to test a single piece of code block (aka functions/methods)
   * Usually methods have dependencies, like other classes or external things like api or DB
   * calls.
   *
   * It is a common practice to mock not relevant dependencies when unit testing something.
   * As they are not relevant for the test, you should not waste time creating unnecessary things.
   *
   * Some languages have mock frameworks, which helps a lot and prevent a lot of extra code for mocking.
   * But at the other hand, some languages are not that powerful, or you are handling with
   * old legacy code bases. In that case, it is common to implement mock classes. This is a more advanced topic.
   */
  @Test
  void unitTests() {}

  @Test
  void GivenAValidCustomer_WhenSaving_ThenCustomerMustExistInDb() {
    //Given Customer
    Customer customer = new Customer(5L, "test", "lastNametest", 20);
    CustomerRepository customerRepository = new CustomerRepository();

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