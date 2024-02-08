package leetcode.arraystrings.problem_151;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
  public static void main(final String[] args) {
    reverseWords("  hello world  ");
  }

  public static String reverseWords(String s) {
    final List<String> inputWords = Arrays.stream(s.split(" ")).filter(Predicate.not(String::isBlank)).map(String::trim).toList();
    final String[] reversed = new String[inputWords.size()];
    for (int i = 0, j = inputWords.size() - 1; i <= j; i++, j--) {
      final String head = inputWords.get(i);
      final String tail = inputWords.get(j);
      reversed[i] = tail;
      reversed[j] = head;
    }
    return Arrays.stream(reversed).collect(Collectors.joining(" "));
  }
}