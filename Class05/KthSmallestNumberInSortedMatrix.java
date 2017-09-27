/**
 *
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order,
 * and for each column the elements are also sorted in ascending order.
 * Find the Kth smallest number in it.
 *
 * Assumptions
 *    the matrix is not null, N > 0 and M > 0
 *    K > 0 and K <= N * M
 * Examples
 *  { {1,  3,   5,  7},
 *
 *    {2,  4,   8,   9},
 *
 *    {3,  5, 11, 15},
 *
 *    {6,  8, 13, 18} }
 *
 *  the 5th smallest number is 4
 *  the 8th smallest number is 6
 *
 **/

public class KthSmallestNumberInSortedMatrix {

  static class Cell {
    int value;
    int x;
    int y;
    Cell(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
    }
  }

  // Best First Search:
  // Start with offering matrix[0][0] into minHeap,
  // and a visited[][] to avoid duplicate insertion into minHeap
  // while minHeap not empty, poll node,
  // insert its right neighbor node and bottom neighbot to minHeap if not visited
  // while k == 1, break loop, and return minHeap.peek().value

  // Time: O(klogk), k offers and k polls
  // Space: O(k + n * m), size k max heap and size m * n visited matrix
  public int kthSmallest(int[][] matrix, int k) {
    // Assumptions:
    // matrix is not null and n > 0 && m > 0
    // k > 0 && k <= n * m
    // Use min heap to provide smallest number every poll
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.value == c2.value) {
          return 0;
        }
        return c1.value < c2.value ? -1 : 1;
      }
    });
    int n = matrix.length, m = matrix[0].length;
    boolean[][] visited = new boolean[n][m];

    minHeap.offer(new Cell(matrix[0][0], 0, 0));
    visited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.y + 1 < m && !visited[cur.x][cur.y + 1]) {
        minHeap.offer(new Cell(matrix[cur.x][cur.y + 1], cur.x, cur.y + 1));
        visited[cur.x][cur.y + 1] = true;
      }
      if (cur.x + 1 < n && !visited[cur.x + 1][cur.y]) {
        minHeap.offer(new Cell(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y));
        visited[cur.x + 1][cur.y] = true;
      }
    }

    return minHeap.peek().value;
  }

}
