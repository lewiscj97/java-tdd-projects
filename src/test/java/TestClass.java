import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  StringSorter stringSorter = new StringSorter();
  String TEST_INPUT = "Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi";

  @Test
  public void splitInputIntoArray() {
    String input = "Tadashi Takahiro Takao";

    List<String> output = stringSorter.sort(input);

    assertEquals("Takahiro", output.get(0));
    assertEquals("Tadashi", output.get(1));
    assertEquals("Takao", output.get(2));
  }

  @Test
  public void sortByNameLength() {
    String input = "AAAAAA AAAAAAAAA";

    List<String> output = stringSorter.sort(input);

    assertEquals("AAAAAAAAA", output.get(0));
    assertEquals("AAAAAA", output.get(1));
  }

  @Test
  public void sortByNameLength_MoreInputs() {
    String input = "AA AAAA AAA AAAAA A";
    List<String> output = stringSorter.sort(input);

    assertEquals("AAAAA", output.get(0));
    assertEquals("AAAA", output.get(1));
    assertEquals("AAA", output.get(2));
    assertEquals("AA", output.get(3));
    assertEquals("A", output.get(4));
  }

  @Test
  public void sortByAlphabetical_allSameLength() {
    String input = "Takayuki Takehiko Takahiro";
    List<String> output = stringSorter.sort(input);

    assertEquals("Takehiko", output.get(0));
    assertEquals("Takayuki", output.get(1));
    assertEquals("Takahiro", output.get(2));
  }

}
