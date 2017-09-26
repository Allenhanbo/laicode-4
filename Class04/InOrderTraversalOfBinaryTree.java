/**
 *
 * Implement an iterative, in-order traversal of a given binary tree,
 * return the list of keys of each node in the tree as it is in-order traversed.
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
 * In-order traversal is [1, 3, 4, 5, 8, 11]
 *
 * Corner Cases
 *    What if the given binary tree is null? Return an empty list in this case.
 *    How is the binary tree represented?
 *    We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 **/

public class InOrderTraversalOfBinaryTree {

  // Create a stack to store every nodes during traversal
  // always go visit left child first
  // if left child is null. poll node from stack, and then store value into result,
  // then visit right child

  // Time: O(n)
  // Space: O(n)
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    // Corner Case
    if (root == null) {
      return result;
    }

    Deque<TreeNode> stack = new LinkedList<>();
    ListNode cur = root;

    while (cur != null || !stack.isEmpty()) {
      if (cur == null) {
        cur = stack.pollLast();
        result.add(cur.key);
        cur = cur.right;
      } else {
        stack.offerLast(cur);
        cur = cur.left;
      }
    }

    return result;
  }

}
