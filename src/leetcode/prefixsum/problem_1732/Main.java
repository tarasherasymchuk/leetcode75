package leetcode.prefixsum.problem_1732;

import java.util.Arrays;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {52, -91, 72};
    largestAltitude(input);
  }

  public static int largestAltitude(int[] gain) {
    final int[] input = new int[gain.length + 1];
    input[0] = 0;
    System.arraycopy(gain, 0, input, 1, gain.length);
    for (int i = 1; i < input.length; i++) {
      input[i] = input[i - 1] + input[i];
    }
    return Arrays.stream(input).skip(1).filter(i -> i >= 0).max().orElse(0);
  }
}
