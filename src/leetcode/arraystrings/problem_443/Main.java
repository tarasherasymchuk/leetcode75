package leetcode.arraystrings.problem_443;

public class Main {
  public static void main(final String[] args) {
    final char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    compress(input);
  }

  public static int compress(char[] chars) {
    char current = chars[0];
    int counter = 0;
    int arrayCounter = 0;
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      if (current == chars[i]) {
        counter++;
      } else {
        sb.append(current);
        if (counter > 1) {
          sb.append(counter);
          arrayCounter = arrayCounter + 2;
        } else {
          arrayCounter = arrayCounter + 1;
        }
        current = chars[i];
        counter = 1;
      }
    }
    sb.append(current);
    if (counter > 1) {
      sb.append(counter);
    }
    final char[] charArray = sb.toString().toCharArray();
    System.arraycopy(charArray, 0, chars, 0, charArray.length);
    return charArray.length;
  }
}