import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wrapper {

  public static String wrap(String input, int column) {
    StringBuilder sb = new StringBuilder();

    String str = input;

    while (str.length() > column) {
      if (input.charAt(column) == ' ') {
        String substr = str.substring(0, column);
        sb.append(substr.trim()).append("\n");
        str = str.replace(substr, "");
      }
    }

    sb.append(str.trim());

    return sb.toString();
  }

}
