/**
 *
 * Given a 2D matrix that contains integers only, which each row is sorted
 * in an ascending order. The first element of next row is larger than
 * (or equal to) the last element of previous row.
 * Given a target number, returning the position that the target locates
 * within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
 *
 * Assumptions:
 *    The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
 * Examples:
 *    matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
 *    target = 7, return {1, 2}
 *    target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 **/

public class SearchInSortedMatrixI {

  // Based on the property of matrix, we can regard the matrix as a 1D array with length m * n
  // map row with length / cols
  // map col with length % cols
  // Then we can find the target by using binary search

  // Time: O(log(mn))
  // Space: O(1)
  public int[] search(int[][] matrix, int target) {
    // Corner Cases
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[] {-1, -1};
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int len = rows * cols;
    int left = 0, right = len - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      // map row with mid / cols
      int row = mid / cols;
      // map col with mid % cols
      int col = mid % cols;
      int val = matrix[row][col];
      if (val == target) {
        return new int[] {row, col};
      } else if (val < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // target not found
    return new int[] {-1, -1};
  }

}
