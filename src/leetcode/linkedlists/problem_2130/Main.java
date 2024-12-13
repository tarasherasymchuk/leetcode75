package leetcode.linkedlists.problem_2130;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {5, 4, 2, 1};
    System.out.println(pairSum(generateLinkedList(input)));
  }

  public static int pairSum(ListNode head) {
    if (head == null) {
      return 0;
    }
    if (head.next == null) {
      return head.val;
    }
    int size = 1;
    ListNode c = head;
    final Map<Integer, Integer> indexToValue = new HashMap<>();
    indexToValue.put(0, head.val);
    while (c.next != null) {
      indexToValue.put(size, c.next.val);
      size++;
      c = c.next;
    }
    final IntBinaryOperator twinIndexFunc = (currentIndex, total) -> total - 1 - currentIndex;
    int sum = 0;
    int counter = 0;
    ListNode first = head;
    while (first != null && counter < (int) Math.ceil(size / 2.0)) {
      final var twinIndex = twinIndexFunc.applyAsInt(counter, size);
      sum = Math.max(sum, first.val + indexToValue.get(twinIndex));
      counter++;
      first = first.next;
    }
    return sum;
  }

  public static ListNode generateLinkedList(final int[] values) {
    if (values == null || values.length == 0) {
      return null;
    }

    final ListNode dummy = new ListNode();
    ListNode current = dummy;

    for (final int value : values) {
      current.next = new ListNode(value);
      current = current.next;
    }

    return dummy.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(final int val) {
      this.val = val;
    }

    ListNode(final int val, final ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
