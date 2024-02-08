package leetcode.arraystrings.problem_1768;

public class Main {
  public static void main(final String[] args) {
    mergeAlternately("qwe123", "asd");
  }

  public static String mergeAlternately(String word1, String word2) {
    final char[] word1Chars = word1.toCharArray();
    final char[] word2Chars = word2.toCharArray();
    final StringBuilder tail = new StringBuilder();
    final int maxIterateValue;
    if (word1Chars.length > word2Chars.length) {
      tail.append(word1.substring(word2Chars.length));
      maxIterateValue = word2Chars.length;
    } else if (word2Chars.length > word1Chars.length) {
      tail.append(word2.substring(word1Chars.length));
      maxIterateValue = word1Chars.length;
    } else {
      maxIterateValue = word1.length();
    }
    final StringBuilder result = new StringBuilder();
    for (int i = 0; i < maxIterateValue; i++) {
      final char w1Char = word1Chars[i];
      final char w2Char = word2Chars[i];
      result.append(w1Char);
      result.append(w2Char);
    }
    return result.append(tail).toString();
  }
}