package leetcode.linkedlists.problem_2095;

public class Main {

  public static void main(final String[] args) {
    final int[] input = {1, 7, 3, 8, 4, 5, 6};
    System.out.println(deleteMiddle(generateLinkedList(input)));
  }

  public static ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    int size = 1;
    ListNode c = head;
    while (c.next != null) {
      size++;
      c = c.next;
    }
    final int mid = (int) Math.ceil(size / 2.0);
    final int removeIndex = size % 2 == 0 ? mid : mid - 1;
    ListNode first = head;
    ListNode second = head;
    int midCounter = 1;
    while (true) {
      if (midCounter == removeIndex) {
        second = second.next;
        first.next = second.next;
        break;
      } else {
        first = first.next;
        midCounter++;
      }
      second = second.next;
    }
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
