/**
 *
 * Get the list of keys in a given binary search tree in a given range[min, max]
 * in ascending order, both min and max are inclusive.
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
 *     1     4        11
 *
 *    get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
 *
 * Corner Cases
 *    What if there are no keys in the given range? Return an empty list in this case.
 * How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class GeyKeysInBSTInRange {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Start with root
  // if (root.key > min), get keys from left subtress
  // if (root.key < max), get keys from right subtrees

  // Time: O(n)
  // Space: O(height)
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<>();
    getRange(root, min, max, result);
    return result;
  }

  // Helper function: getRange
  // In order traverse the tree to get ascending order result
  private void getRange(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
      return;
    }

    // Determine whether keep going left
    if (root.key > min) {
      getRange(root.left, min, max, result);
    }

    // Determin whether add key to result
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }

    // Determine whether keep going right
    if (root.key < max) {
      getRange(root.right, min, max, result);
    }
  }

}
