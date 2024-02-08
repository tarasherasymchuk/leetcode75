package leetcode.slidingwindow.problem_1456;

import java.util.Map;

public class Main {

  public static void main(final String[] args) {
    final String input = "leetcode";
    final int k = 3;
    maxVowels(input, k);
  }

  public static int maxVowels(String s, int k) {
    final char[] input = s.toCharArray();
    final Map<Character, Integer> vowels = Map.of('a', 1, 'e', 1, 'i', 1, 'o', 1, 'u', 1);
    int vowelsCounter = 0;
    for (int i = 0; i < k; i++) {
      vowelsCounter += vowels.getOrDefault(input[i], 0);
    }
    int max = vowelsCounter;
    for (int i = k; i < input.length; i++) {
      final char toRemove = input[i - k];
      final char toAdd = input[i];
      final int toRemoveValue = vowels.getOrDefault(toRemove, 0);
      final int toAddValue = vowels.getOrDefault(toAdd, 0);
      vowelsCounter = vowelsCounter - toRemoveValue + toAddValue;
      if (vowelsCounter > max) {
        max = vowelsCounter;
      }
    }
    return max;
  }
}
