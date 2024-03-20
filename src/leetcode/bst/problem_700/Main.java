package leetcode.bst.problem_700;

public class Main {

  public static void main(final String[] args) {
    final var root = TreeNode.generateTree(15, 4);
    final TreeNode result = searchBST(root, 4);
    System.out.println(result == null ? "Not found" : result.val);
  }

  public static TreeNode searchBST(final TreeNode root, final int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }

    if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(final int val) {
      this.val = val;
    }

    TreeNode(final int val, final TreeNode left, final TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public static TreeNode generateTree(final int depth, final int val) {
      if (depth == 0) {
        return null;
      }

      final TreeNode node = new TreeNode(val);
      node.left = generateTree(depth - 1, 2 * val);
      node.right = generateTree(depth - 1, 2 * val + 1);

      return node;
    }
  }
}
