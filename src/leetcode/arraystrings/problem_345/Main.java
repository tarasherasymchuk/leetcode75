package leetcode.arraystrings.problem_345;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(final String[] args) {
    reverseVowels("aA");
  }

  public static String reverseVowels(String s) {
    final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    final char[] input = s.toCharArray();
    final List<Integer> vowelsIndexes = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      if (vowels.contains(input[i])) {
        vowelsIndexes.add(i);
      }
    }
    for (int i = 0, j = vowelsIndexes.size() - 1; i <= j; i++, j--) {
      final int head = vowelsIndexes.get(i);
      final int tail = vowelsIndexes.get(j);
      final char ch = input[head];
      input[head] = input[tail];
      input[tail] = ch;
    }
    return new StringBuilder().append(input).toString();
  }
}