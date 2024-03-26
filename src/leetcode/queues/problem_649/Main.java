package leetcode.queues.problem_649;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  public static void main(final String[] args) {
    System.out.println(predictPartyVictory("DRDRR"));
  }

  public static String predictPartyVictory(String senate) {
    final Queue<Integer> dq = new ArrayDeque<>();
    final Queue<Integer> rq = new ArrayDeque<>();

    final int senateCapacity = senate.length();
    for (int i = 0; i < senateCapacity; i++) {
      if (senate.charAt(i) == 'R') {
        rq.add(i);
      } else {
        dq.add(i);
      }
    }
    while (!rq.isEmpty() && !dq.isEmpty()) {
      final Integer rs = rq.poll();
      final Integer ds = dq.poll();
      if (rs < ds) {
        rq.add(senateCapacity + rs);
      } else {
        dq.add(senateCapacity + ds);
      }
    }
    return rq.size() > dq.size() ? "Radiant" : "Dire";
  }
}
