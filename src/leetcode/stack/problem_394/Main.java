package leetcode.stack.problem_394;

public class Main {
  private int counter = -1;

  public static void main(final String[] args) {
    final String s = new Main().decodeString("2[abc]3[cd]ef");
    System.out.println(s);
  }

  public String decodeString(final String s) {
    final StringBuilder output = new StringBuilder();
    final StringBuilder multiplier = new StringBuilder();
    while (++counter < s.length()) {
      final char current = s.charAt(counter);
      if (Character.isDigit(current)) {
        multiplier.append(current);
      } else if (current == '[') {
        final String next = decodeString(s);
        output.append(next.repeat(Math.max(1, Integer.parseInt(multiplier.toString()))));
        multiplier.setLength(0);
      } else if (current == ']') {
        return output.toString();
      } else {
        output.append(current);
      }
    }
    return output.toString();
  }
}
