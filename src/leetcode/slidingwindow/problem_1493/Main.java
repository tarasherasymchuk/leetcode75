package leetcode.slidingwindow.problem_1493;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {0, 1, 1, 1, 0, 1, 1, 0, 1};
    longestSubarray(input);
  }

  public static int longestSubarray(int[] nums) {
    int sum = 0;
    int extensionCounter = 0;
    int left = 0;
    int right = 0;
    int max = 0;
    while (left < nums.length && right < nums.length) {
      if (nums[right] == 1) {
        sum++;
        right++;
      } else {
        if (extensionCounter < 1) {
          extensionCounter++;
          sum++;
          right++;
        } else {
          extensionCounter = 0;
          left++;
          sum = 0;
          right = left;
        }
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max - 1;
  }
}
