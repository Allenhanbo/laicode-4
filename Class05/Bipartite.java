/**
 *
 * Determine if an undirected graph is bipartite. A bipartite graph is one
 * in which the nodes can be divided into two groups such that no nodes
 * have direct edges to other nodes in the same group.
 *
 * Examples
 *
 *    1  --   2
 *
 *        /
 *
 *    3  --   4
 *
 *    is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 *
 *    1  --   2
 *
 *        /   |
 *
 *    3  --   4
 *
 *    is not bipartite.
 *
 * Assumptions
 *    The graph is represented by a list of nodes, and the list of nodes is not null.
 *
 **/

public class Bipartite {

  static class GraphNode {
    int key;
    List<GraphNode> neighbors;
    GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<>();
    }
  }

  // Use a hashmap to store visited GraphNode to avoid duplicate visit, and check whether the graph is bipartite
  // Start with the first GraphNode in the list, set its group to 1, and store it into hashmap as visited
  // Iterate through its neighbors,
  // if not visited, set its group to 2, and store it into hashmap as visited
  // if visited, check whether its group is not the same as current GraphNode's group.
  // If group is the same, return false
  // return true after all GraphNodes in the graph are visited

  // Time: O(V + E)
  // Space: O(V)
  public boolean isBipartite(List<GraphNode> graph) {
    Map<GraphNode, Integer> visited = new HashMap<>();
    for (GraphNode node : graph) {
      if (!bfs(node, visited)) {
        return false;
      }
    }
    return true;
  }

  // Helper function: bfs
  // return false if the graph is not bipartite
  private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
    if (visited.containsKey(node)) {
      return true;
    }

    // Use Queue to do bfs
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    visited.put(node, 1);

    while (!queue.isEmpty()) {
      for (int size = queue.size(); size > 0; size--) {
        GraphNode cur = queue.poll();
        for (GraphNode nei : cur.neighbors) {
          // group number for cur GraphNode
          int curGroup = visited.get(cur);
          // group number for neighbor GraphNode
          int neiGroup = curGroup == 1 ? 2 : 1;
          // if neighbor GraphNode is not visited, mark it visited with neiGroup
          // and put it into queue for next round of BFS
          if (!visited.containsKey(nei)) {
            queue.offer(nei);
            visited.put(nei, neiGroup);
          // if neighbor GraphNode is visited and its group number is not same as neiGroup
          // return false;
          } else if (visited.get(nei) != neiGroup) {
            return false;
          }
        }
      }
    }

    return true;
  }

}
