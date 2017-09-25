/*
 *
 * Given a target integer T, a non-negative integer K and an integer array A
 * sorted in ascending order, find the K closest numbers to T in A.
 *
 * Assumptions
 *    A is not null
 *    K is guranteed to be >= 0 and K is guranteed to be <= A.length
 * Return
 *    A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
 * Examples
 *    A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 *    A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */

public class KClosestInSortedArray {

  // Find the closest number first, and then compare its left and right values
  // to decide which to add to result array

  // Time: (logn + k)
  // Space: O(1)
  public int[] kClosest(int[] array, int target, int k) {
    // Corner Cases
    if (array == null || array.length == 0) {
      return new int[0];
    }

    int[] result = new int[k];
    // the number of elements in the result array
    int count = 0;

    // Find the closest number's index
    int left = findClosest(array, target);
    // The index of next candidates of result array
    int right = left + 1;

    // keep adding k numbers into result array
    for (int i = 0; i < k; i++) {
      if (right >= array.length || left >= 0 && target - array[left] < array[right] - target) {
        result[count++] = array[left--];
      } else {
        result[count++] = array[right++];
      }
    }

    return result;
  }

  // helper function: findClosest
  // return the closest number's index
  private int findClosest(int[] array, int target) {
    int left = 0, right = array.length - 1;
    while (left + 1 < right) {
      // left + (right - left) / 2 to avoid overflow
      int mid = left + (right - left) / 2;
      if (array[mid] == left) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    // return the closest number's index
    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
      return left;
    } else {
      return right;
    }
  }

}
