package leetcode.arraystrings.problem_605;

import java.util.function.BiPredicate;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 0, 0, 0, 1, 0, 0};
    canPlaceFlowers(input, 2);
  }

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    boolean canPlace = false;
    if (n == 0) {
      return true;
    }
    if (flowerbed.length == 1 && flowerbed[0] == 0) {
      return true;
    }
    int lastIndex = 0;
    final BiPredicate<Integer, int[]> checkIfCanPlaceAtFirst = (pos, items) -> pos == 0 && items[pos] == 0 && items[pos + 1] == 0;
    final BiPredicate<Integer, int[]> checkIfCanPlaceAtLast = (pos, items) -> pos + 1 == items.length && items[pos] == 0 && items[pos - 1] == 0;
    final BiPredicate<Integer, int[]> checkIfCanPlace = (pos, items) -> pos + 1 < items.length && items[pos] != 1 && items[pos + 1] != 1 && (pos > 0 && items[pos - 1] != 1);
    for (int j = 0; j < n; j++) {
      for (int i = lastIndex; i < flowerbed.length; i++) {
        if (checkIfCanPlaceAtFirst.or(checkIfCanPlaceAtLast.or(checkIfCanPlace)).test(i, flowerbed)) {
          flowerbed[i] = 1;
          lastIndex = i;
          canPlace = true;
          break;
        }
        canPlace = false;
      }
    }
    return canPlace;
  }
}