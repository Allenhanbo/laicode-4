/**
 *
 * Check if a given binary tree is symmetric.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        3
 *
 *   /   \    /   \
 *
 * 1      4  4      1
 *
 * is symmetric.
 *
 *          5
 *
 *        /    \
 *
 *      3        3
 *
 *    /   \    /   \
 *
 *  1      4  1      4
 *
 *  is not symmetric.
 *
 * Corner Cases
 *    What if the binary tree is null? Return true in this case.
 * How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class SymmetricBinaryTree {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Recursively checking whether root1.left == root2.right && root1.right == root2.left

  // Time: O(n)
  // Space: O(height)
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  // Helper function: isSymmetric
  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.key != right.key) {
      return false;
    }

    return isSymmetric(left.left, right.right)
           && isSymmetric(left.right, right.left);
  }

}
