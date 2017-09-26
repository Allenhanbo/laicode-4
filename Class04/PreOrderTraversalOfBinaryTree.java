/**
 *
 * Implement an iterative, pre-order traversal of a given binary tree,
 * return the list of keys of each node in the tree as it is pre-order traversed.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * Pre-order traversal is [5, 3, 1, 4, 8, 11]
 *
 * Corner Cases
 *    What if the given binary tree is null? Return an empty list in this case.
 *    How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class PreOrderTraversalOfBinaryTree {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Create a stack to store nodes during traversal
  // Always add node to result first, if right child is not null, push it to stack, and then visit left child
  // if left child is null, poll node from stack, which is the parent's right child

  // Time: O(n)
  // Space: O(n)
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    // Corner Cases
    if (root == null) {
      return result;
    }

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
      // Since node in stack was visited
      // just go to right child
      if (cur == null) {
        cur = stack.pollLast();
      }
      result.add(cur.key);
      if (cur.right != null) {
        stack.offerLast(cur.right);
      }
      cur = cur.left;
    }

    return result;
  }

}
