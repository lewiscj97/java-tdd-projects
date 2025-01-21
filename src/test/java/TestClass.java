import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  Service service = new Service();

  @Test
  public void initialTest() {
    String expected = "Hello, World!";

    String output = service.helloWorld();

    assertEquals(expected, output);
  }

}
