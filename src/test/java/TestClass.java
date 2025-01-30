import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  @Test
  public void splitAtSpace_TwoLines() {
    String input = "Here is a test input for the function";
    int column = 20;

    String expected = "Here is a test input\nfor the function";

    String output = Wrapper.wrap(input, column);

    assertEquals(expected, output);
  }

  @Test
  public void splitAtSpace_ThreeLines() {
    String input = "Here is a test input for the function in an easy case";
    int column = 20;

    String expected = "Here is a test input\nfor the function in\nan easy case";

    String output = Wrapper.wrap(input, column);

    assertEquals(expected, output);
  }

}
