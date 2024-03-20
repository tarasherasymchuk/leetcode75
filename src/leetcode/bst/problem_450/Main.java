package leetcode.bst.problem_450;

public class Main {

  public static void main(final String[] args) {
    final var l2 = new TreeNode(2);
    final var r2 = new TreeNode(4);
    final var l1 = new TreeNode(3, l2, r2);
    final var r3 = new TreeNode(7);
    final var r1 = new TreeNode(6, null, r3);
    final var root = new TreeNode(5, l1, r1);
    final TreeNode result = deleteNode(root, 5);
    System.out.println(result == null ? "Not found" : result.val);
  }

  public static TreeNode deleteNode(final TreeNode root, final int val) {
    if (root == null) {
      return null;
    }
    if (root.val < val) {
      root.right = deleteNode(root.right, val);
    } else if (root.val > val) {
      root.left = deleteNode(root.left, val);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode current = root.right;
        while (current.left != null) {
          current = current.left;
        }
        root.val = current.val;
        root.right = deleteNode(root.right, current.val);
      }
    }
    return root;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(final int val) {
      this.val = val;
    }

    TreeNode(final int val, final TreeNode left, final TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
