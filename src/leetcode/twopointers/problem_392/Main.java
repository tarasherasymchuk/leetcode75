package leetcode.twopointers.problem_392;

public class Main {

  public static void main(final String[] args) {
    isSubsequence("abc", "ahbgdc");
  }

  public static boolean isSubsequence(String s, String t) {
    int sl = 0;
    int tl = 0;
    final char[] sCharArray = s.toCharArray();
    final char[] tCharArray = t.toCharArray();
    final StringBuilder sb = new StringBuilder();
    while (sl < s.length() && tl < t.length()) {
      if (sCharArray[sl] == tCharArray[tl]) {
        sb.append(tCharArray[tl]);
        sl++;
      }
      tl++;
    }
    return s.equals(sb.toString());
  }
}
