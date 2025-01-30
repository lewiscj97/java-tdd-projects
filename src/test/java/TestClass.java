import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  StringSorter stringSorter = new StringSorter();
  String TEST_INPUT = "Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi";

  @Test
  public void splitInputIntoArray() {
    String input = "Tadashi Takahiro Takao";

    List<String> output = stringSorter.split(input);

    assertEquals("Tadashi", output.get(0));
    assertEquals("Takahiro", output.get(1));
    assertEquals("Takao", output.get(2));
  }

}
