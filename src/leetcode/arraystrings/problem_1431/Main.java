package leetcode.arraystrings.problem_1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(final String[] args) {
    final int[] input = {2,3,5,1,3};
    kidsWithCandies(input, 3);
  }

  public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    final int max = Arrays.stream(candies).max().getAsInt();
    final List<Boolean> result = new ArrayList<>();
    for (final int candy : candies) {
      result.add(candy + extraCandies >= max);
    }
    return result;
  }
}