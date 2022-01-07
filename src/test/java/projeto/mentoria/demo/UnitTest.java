package projeto.mentoria.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projeto.mentoria.demo.model.Customer;
import projeto.mentoria.demo.repository.CustomerRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UnitTest {

  /**
   * This annotation define that this class will be managed by Mockito.
   * Which means that we can control its behavior programmatically to mimic certain scenarios.
   * Let's see on an example below
   */
  @Mock CustomerRepository customerRepository;

  /**
   * JUnit Specific to unit test something with mocks. This annotation will inject
   * all dependencies defined mocks into this class. In our case, we still don't have anything.
   */
  //@InjectMocks CustomerService customerService;

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
  void GivenSomething_WhenSomething_ThenSomething() {
    //Given
    when(
        customerRepository.getCustomerById(any())
    )
    .thenReturn(
        new Customer(11L, "firstName", "lastName", 20)
    );

    /**
     * now every time this method {@link CustomerRepository#getCustomerById(long)} is called
     * it will return this defined customer.
     *
     * This is very helpful when we don't want to test if DB calls are working, but just receive something
     * from this method to keep going with our main test.
     */
  }
}
