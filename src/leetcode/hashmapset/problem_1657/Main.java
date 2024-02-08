package leetcode.hashmapset.problem_1657;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(final String[] args) {
    final String word1 = "cabbba";
    final String word2 = "aabbss";
    closeStrings(word1, word2);
  }

  public static boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    final char[] word1Chars = word1.toCharArray();
    Arrays.sort(word1Chars);
    final char[] word2Chars = word2.toCharArray();
    Arrays.sort(word2Chars);
    if (String.valueOf(word1Chars).equals(String.valueOf(word2Chars))) {
      return true;
    }

    final Map<Character, Integer> word1CharOccurrences = countOccurrences(word1Chars);
    final Map<Character, Integer> word2CharOccurrences = countOccurrences(word2Chars);

    if (!word1CharOccurrences.keySet().containsAll(word2CharOccurrences.keySet())) {
      return false;
    }

    final List<Integer> word1Occurrences = word1CharOccurrences.values().stream().sorted().toList();
    final List<Integer> word2Occurrences = word2CharOccurrences.values().stream().sorted().toList();
    return IntStream.range(0, word2Occurrences.size()).allMatch(index -> word1Occurrences.get(index).compareTo(word2Occurrences.get(index)) == 0);
  }

  private static Map<Character, Integer> countOccurrences(final char[] chars) {
    return IntStream.range(0, chars.length)
            .mapToObj(i -> chars[i])
            .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    List::size)
                    )
            );
  }
}
