package leetcode.twopointers.problem_1679;

import java.util.Arrays;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {2, 2, 2, 3, 1, 1, 4, 1};
    final int k = 4;
    maxOperations(input, k);
  }

  public static int maxOperations(int[] nums, int k) {
    int i = 0;
    int j = nums.length - 1;
    int counter = 0;
    Arrays.sort(nums);
    while (i < j) {
      if (nums[i] + nums[j] == k) {
        counter++;
        i++;
        j--;
      } else if (nums[i] + nums[j] < k) {
        i++;
      } else {
        j--;
      }
    }
    return counter;
  }
}
