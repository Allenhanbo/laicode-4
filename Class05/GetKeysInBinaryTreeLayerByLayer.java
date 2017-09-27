/**
 *
 * Get the list of list of keys in a given binary tree layer by layer.
 * Each layer is represented by a list of keys and the keys are traversed from left to right.
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
 *  the result is [ [5], [3, 8], [1, 4, 11] ]
 *
 * Corner Cases
 *    What if the binary tree is null? Return an empty list of list in this case.
 *
 **/

public class GetKeysInBinaryTreeLayerByLayer {

  static class TreeNode {
    int key;
    TreeNode left, right;
    TreeNode(int key) {
      this.key = key;
    }
  }

  // Use a queue to traverse Tree Layer by layer

  // Time: O(n)
  // Space: O(n)
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    // Corner Case
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      for (int size = queue.size(); size > 0; size--) {
        TreeNode cur = queue.poll();
        list.add(cur.key);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      result.add(list);
    }
    return result;
  }

}
