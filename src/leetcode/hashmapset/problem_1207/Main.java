package leetcode.hashmapset.problem_1207;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 2, 2, 1, 1, 3};
    uniqueOccurrences(input);
  }

  public static boolean uniqueOccurrences(int[] arr) {
    final Map<Integer, List<Integer>> grouped = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity()));
    final Set<Integer> valuesSizes = grouped.values().stream()
            .map(List::size)
            .collect(Collectors.toSet());
    return valuesSizes.size() == grouped.keySet().size();
  }
}
