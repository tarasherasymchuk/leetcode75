package leetcode.twopointers.problem_11;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    maxArea(input);
  }

  public static int maxArea(int[] height) {
    if (height.length == 1) {
      return height[0];
    }
    if (height.length == 2) {
      return Math.min(height[0], height[1]);
    }
    int i = 0;
    int j = height.length - 1;
    int area = 0;
    while (i < height.length && j > i) {
      /*
          we should look for a max distance between two points in the given array.
          use two pointers two iterate the array from both ends and while iterating it,
          we are comparing them to determine the smaller value. The max height of the container
          is determined by the minimal value out of two elements in the array (y-axis).
          once we have it, the next step is to calculate the distance
          between elements in comparison (x-axis).
          the last step is to calculate the area and compare it with the previous value.
       */
      area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return area;
  }
}
