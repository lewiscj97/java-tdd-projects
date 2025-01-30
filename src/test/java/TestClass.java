import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  Wrapper wrapper = new Wrapper();

  @Test
  public void initialTest() {
    String input = "Here is a test input for the function";
    int column = 20;

    String expected = "Here is a test input\nfor the function";

    String output = wrapper.wrap(input, column);

    assertEquals(expected, output);
  }

}
