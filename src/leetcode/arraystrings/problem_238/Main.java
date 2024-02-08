package leetcode.arraystrings.problem_238;

public class Main {

  public static void main(final String[] args) throws Exception {
    final int[] input = {1, 2, 3, 4};
    productExceptSelf(input);
  }

  public static int[] productExceptSelf(int[] nums) {
    final int[] left = new int[nums.length];
    final int[] right = new int[nums.length];

    left[0] = 1;
    right[nums.length - 1] = 1;

    for (int i = 1; i < nums.length; i++) {
      left[i] = nums[i - 1] * left[i - 1];
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      right[i] = nums[i + 1] * right[i + 1];
    }

    final int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = left[i] * right[i];
    }
    return result;
  }
}