import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wrapper {

  public static String wrap(String input, int column) {
    StringBuilder sb = new StringBuilder();

    String str = input;

    if (input.charAt(column) == ' ') {
      String substr = input.substring(0, column);
      sb.append(substr).append("\n");
      str = input.replace(substr, "");
    }

    sb.append(str.trim());

    return sb.toString();
  }

}
