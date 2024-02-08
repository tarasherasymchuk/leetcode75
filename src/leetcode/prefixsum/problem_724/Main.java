package leetcode.prefixsum.problem_724;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 7, 3, 6, 5, 6};
    pivotIndex(input);
  }

  public static int pivotIndex(int[] input) {
    if (input.length == 1) {
      return 0;
    }
    int leftSum;
    int rightSum;
    for (int i = 0; i < input.length; i++) {
      leftSum = sumLeft(input, i);
      rightSum = sumRight(input, i);
      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }

  private static int sumLeft(int[] input, int startIndex) {
    int total = 0;
    for (int i = 0; i < startIndex; i++) {
      total += input[i];
    }
    return total;
  }

  private static int sumRight(int[] input, int startIndex) {
    int total = 0;
    for (int i = startIndex + 1; i < input.length; i++) {
      total += input[i];
    }
    return total;
  }
}
