package leetcode.stack.problem_735;

import java.util.Arrays;
import java.util.Stack;

public class Main {

  public static void main(final String[] args) {
    final int[] s = asteroidCollision(new int[]{1, -2, -2, -2});
    System.out.println(s);
  }

  public static int[] asteroidCollision(int[] asteroids) {
    final var s = new Stack<Integer>();
    final boolean allRight = Arrays.stream(asteroids).allMatch(i -> i > 0);
    final boolean allLeft = Arrays.stream(asteroids).allMatch(i -> i < 0);
    if (allRight || allLeft) {
      return asteroids;
    }
    for (final int i : asteroids) {
      if (s.isEmpty() || i > 0) {
        s.add(i);
      } else {
        while (true) {
          final Integer previous = s.peek();
          if (previous < 0) {
            // edge case, keeping negative values because they move in another direction
            s.add(i);
            break;
          } else if ((i ^ previous) < 0 && Math.abs(i) == Math.abs(previous)) {
            // same size - explode
            s.pop();
            break;
          } else if (previous > -i) {
            // the current one is smaller than the previous one, skipping the current one
            break;
          } else {
            // left over case - removing the previous one as it's smaller
            s.pop();
            if (s.empty()) {
              s.add(i);
              break;
            }
          }
        }
      }
    }
    return s.isEmpty() ? new int[]{} : s.stream().mapToInt(Integer::intValue).toArray();
  }
}
