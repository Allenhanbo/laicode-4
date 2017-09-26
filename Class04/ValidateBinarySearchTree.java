/**
 *
 * Determine if a given binary tree is binary search tree.
 *
 * Assumptions
 *    There are no duplicate keys in binary search tree.
 *    You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
 * Corner Cases
 *    What if the binary tree is null? Return true in this case.
 *
 **/

public class ValidateBinarySearchTree {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Start with [Integer.MIN_VALUE, Integer.MAX_VALUE]
  // if check root.left, then range becomes [min, root.value - 1]
  // if check root.right, then range becomes [root.value + 1, max]

  // Time: O(n)
  // Space: O(height)
  public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // Helper function: isBST
  private boolean isBST(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    } else if (root.key < min || root.key > max) {
      return false;
    }
    return isBST(root.left, min, root.key - 1)
           && isBST(root.right, root.key + 1, max);
  }

}
