import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StringSorter {

  public List<String> sort(String input) {
    List<String> splitInput = new ArrayList<>(List.of(input.split(" ")));
    List<String> output = new ArrayList<>();

    int length = splitInput.size();

    while (length != 0) {
      String longestString = "";

      for (String s : splitInput) {
        if (s.length() > longestString.length()) {
          longestString = s;
        }
      }

      output.add(longestString);
      splitInput.remove(longestString);
      length--;
    }

    return output;
  }

}
