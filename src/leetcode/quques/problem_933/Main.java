package leetcode.quques.problem_933;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

  public static void main(final String[] args) {
    final RecentCounter recentCounter = new RecentCounter();
    final List<Integer> list = Stream.of(1, 100, 3001, 3002).map(recentCounter::ping).toList();
    System.out.println(list);
  }

  static class RecentCounter {

    private final List<Integer> list = new ArrayList<>();

    public int ping(final int t) {
      list.add(t);
      final Iterator<Integer> iterator = list.iterator();
      while (iterator.hasNext() && iterator.next().compareTo(t - 3000) < 0) {
        iterator.remove();
      }
      return list.size();
    }
  }

}
