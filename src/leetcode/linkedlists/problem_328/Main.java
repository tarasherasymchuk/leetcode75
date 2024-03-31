package leetcode.linkedlists.problem_328;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {2, 1, 3, 5, 6, 4, 7};
    System.out.println(oddEvenList(generateLinkedList(input)));
  }

  public static ListNode oddEvenList(final ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    final ListNode even = head.next;
    ListNode o = head;
    ListNode e = even;
    while (e != null && e.next != null) {
      o.next = e.next;
      o = o.next;
      e.next = o.next;
      e = e.next;
    }
    o.next = even;
    return head;
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
