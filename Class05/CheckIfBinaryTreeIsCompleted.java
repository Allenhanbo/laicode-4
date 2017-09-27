/**
 *
 * Check if a given binary tree is completed. A complete binary tree is one
 * in which every level of the binary tree is completely filled except
 * possibly the last level. Furthermore, all nodes are as far left as possible.
 *
 * Examples
 *
 *            5
 *
 *          /    \
 *
 *        3        8
 *
 *      /   \
 *
 *    1      4
 *
 *    is completed.
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
 *    is not completed.
 *
 * Corner Cases
 *    What if the binary tree is null? Return true in this case.
 * How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class CheckIfBinaryTreeIsCompleted {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Using a queue to level order traverse the tree
  // For each node, check both of its left and right children
  // if any child is null, then no more child nodes are allowd,
  // if another child exists, return false
  // return true after traversal the whole tree

  // Time: O(n)
  // Space: O(n)
  public boolean isCompleted(TreeNode root) {
    // Corner Case
    if (root == null) {
      return true;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean noMoreChild = false;

    while (!queue.isEmpty()) {
      // Traverse the current size of queue, which is the size of current level
      for (int size = queue.size(); size > 0; size--) {
        TreeNode cur = queue.poll();
        if (cur.left == null) {
          noMoreChild = true;
        } else if (noMoreChild) {
          return false;
        } else {
          queue.offer(cur.left);
        }

        if (cur.right == null) {
          noMoreChild = true;
        } else if (noMoreChild) {
          return false;
        } else {
          queue.offer(cur.right);
        }
      }
    }
    return true;
  }

}
