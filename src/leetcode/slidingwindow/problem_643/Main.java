package leetcode.slidingwindow.problem_643;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {4, 2, 1, 3, 3};
    final int k = 2;
    findMaxAverage(input, k);
  }

  public static double findMaxAverage(int[] nums, int k) {
    double kSum = 0.0;
    for (int i = 0; i < k; i++) {
      kSum += nums[i];
    }
    double maxAverage = kSum / k;
    for (int i = k; i < nums.length; i++) {
      kSum = kSum - nums[i - k] + nums[i];
      maxAverage = Math.max(maxAverage, kSum / k);
    }
    return maxAverage;
  }
}
