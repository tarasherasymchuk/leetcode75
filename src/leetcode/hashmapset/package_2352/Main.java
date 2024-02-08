package leetcode.hashmapset.package_2352;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(final String[] args) {
    final int[][] grid = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
    };
//    final int[][] grid = {
//            {3, 1, 2, 2},
//            {1, 4, 4, 5},
//            {2, 4, 2, 2},
//            {2, 4, 2, 2},
//    };
//    final int[][] grid = {
//            {13, 13},
//            {13, 13},
//    };
//    final int[][] grid = {
//            {13, 13},
//            {13, 13},
//    };
    equalPairs(grid);
  }

  public static int equalPairs(int[][] grid) {
    final Map<String, Integer> rowOccurrences = new HashMap<>();
    for (final int[] value : grid) {
      final String row = Arrays.toString(value);
      rowOccurrences.merge(row, 1, Integer::sum);
    }
    int counter = 0;
    for (int i = 0; i < grid.length; i++) {
      final int[] column = new int[grid.length];
      for (int j = 0; j < column.length; j++) {
        column[j] = grid[j][i];
      }
      final String row = Arrays.toString(column);
      if (rowOccurrences.containsKey(row)) {
        counter += rowOccurrences.get(row);
      }
    }
    return counter;
  }
}
