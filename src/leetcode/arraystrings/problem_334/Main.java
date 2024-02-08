package leetcode.arraystrings.problem_334;

public class Main {
  public static void main(final String[] args) {
    final int[] input = {20, 100, 10, 12, 5, 13};
    increasingTriplet(input);
  }

  public static boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int minOne = Integer.MAX_VALUE;
    int minTwo = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num < minOne) {
        minOne = num;
      }

      if (num > minOne) {
        minTwo = Math.min(num, minTwo);
      }

      if (num > minTwo) {
        return true;
      }
    }
    return false;
  }
}