import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StringSorter {

  public List<String> split(String input) {
    return List.of(input.split(" "));
  }

}
