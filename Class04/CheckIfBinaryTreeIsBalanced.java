/**
 *
 * Check if a given binary tree is balanced. A balanced binary tree is one
 * in which the depths of every node’s left and right subtree differ by at most 1.
 *
 * Examples
 *
 *            5
 *
 *          /    \
 *
 *        3        8
 *
 *      /   \        \
 *
 *    1      4        11
 *
 *    is balanced binary tree,
 *
 *            5
 *
 *          /
 *
 *        3
 *
 *      /   \
 *
 *    1      4
 *
 *    is not balanced binary tree.
 *
 * Corner Cases
 *    What if the binary tree is null? Return true in this case.
 *
 * How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public CheckIfBinaryTreeIsBalanced {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Recursively get height of left and right subtrees
  // if the left height and right height differ more than 1, return -1
  // else return 1 + the max height between left and rgiht

  // Time: O(n)
  // Space: O(height)
  public boolean isBalanced(TreeNode root) {
    return getHeight(root) != -1;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = getHeight(root.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = getHeight(root.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return 1 + Math.max(leftHeight, rightHeight);
  }

}
