package leetcode.twopointers.problem_283;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
    new Main().moveZeroes(input);
  }

  public void moveZeroes(int[] nums) {
    if (nums.length == 1) {
      return;
    }
    int l1 = 0;
    int l2 = 1;
    while (l1 < nums.length && l2 < nums.length) {
      if (nums[l1] == 0 && nums[l2] != 0) {
        final int nonZero = nums[l2];
        nums[l1] = nonZero;
        nums[l2] = 0;
        if (l1 != 0 && l2 != 0) {
          l1--;
          l2--;
        }
      } else {
        l1++;
        l2++;
      }
    }
  }
}
