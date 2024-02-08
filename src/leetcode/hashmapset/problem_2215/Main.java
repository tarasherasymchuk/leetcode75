package leetcode.hashmapset.problem_2215;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

  public static void main(final String[] args) {
    final int[] input1 = {1, 2, 3};
    final int[] input2 = {2, 4, 6};
    new Main().findDifference(input1, input2);
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    final Map<Integer, Boolean> input1 = Arrays.stream(nums1).boxed().distinct()
            .collect(Collectors.toMap(Function.identity(), s -> true));
    final Map<Integer, Boolean> input2 = Arrays.stream(nums2).boxed().distinct()
            .collect(Collectors.toMap(Function.identity(), s -> true));
    for (final int j : nums2) {
      input1.remove(j);
    }
    for (final int j : nums1) {
      input2.remove(j);
    }
    return List.of(List.copyOf(input1.keySet()), List.copyOf(input2.keySet()));
  }

}
