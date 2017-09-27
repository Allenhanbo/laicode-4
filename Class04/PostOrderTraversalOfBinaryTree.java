/**
 *
 * Implement an iterative, post-order traversal of a given binary tree,
 * return the list of keys of each node in the tree as it is post-order traversed.
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
 * In-order traversal is [1, 4, 3, 11, 8, 5]
 *
 * Corner Cases
 *    What if the given binary tree is null? Return an empty list in this case.
 *    How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class PostOrderTraversalOfBinaryTree {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // cur starts with root, prev starts as null
  // if prev != cur.left && prev != cur.right, push cur to stack and visit left child
  // if cur == null, cur = poll from stack
  // if prev == cur.left, push cur and visit right child
  // if prev == cur.right, add cur to result

  // Time: O(n)
  // Space: (height)
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    // Corner Case
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root, prev = null;
    stack.offerLast(cur);
    while (!stack.isEmpty()) {
      if (prev == null || prev.left == cur || prev.right == cur) { // When prev is cur's parent or null
        prev = cur;
        if (cur.left == null && cur.right == null) {
          result.add(cur.key);
          cur = stack.pollLast();
        } else {
          stack.offerLast(cur);
          // Visit left if possible, otherwise, visit right
          cur = cur.left != null ? cur.left : cur.right;
        }
      } else if (prev == cur.right || prev == cur.left && cur.right == null) { // When to add cur to result
        result.add(cur.key);
        prev = cur;
        cur = stack.pollLast();
      } else { // When to visit right child
        stack.offerLast(cur);
        prev = cur;
        cur = cur.right;
      }
    }
    return result;
  }
}
