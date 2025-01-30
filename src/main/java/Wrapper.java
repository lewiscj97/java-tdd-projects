import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wrapper {

  public static String wrap(String input, int column) {
    StringBuilder sb = new StringBuilder();

    String str = input;

    while (str.length() > column) {
      if (isSplitAtSpace(str, column)) {
        str = addRowToStringBuilder(str, column, sb);
      } else {
        int splitIndex = getIndexOfLastSpace(input, column);
        str = addRowToStringBuilder(str, splitIndex, sb);
      }
    }

    sb.append(str.trim());

    return sb.toString();
  }

  public static String addRowToStringBuilder(String str, int splitIndex, StringBuilder sb) {
    String substr = str.substring(0, splitIndex);
    sb.append(substr.trim()).append("\n");
    return str.replace(substr, "");
  }

  public static int getIndexOfLastSpace(String input, int column) {
    return input.substring(0, column).lastIndexOf(' ');
  }


  public static boolean isSplitAtSpace(String input, int column) {
    return input.charAt(column) == ' ';
  }
}
