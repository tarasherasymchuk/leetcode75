package leetcode.linkedlists.problem_206;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 7, 3, 6, 5, 6};
    System.out.println(reverseList(generateLinkedList(input)));
  }

  public static ListNode reverseList(final ListNode head) {
    ListNode previous = null;
    var current = head; // 1
    while (current != null) {
      final var next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
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
