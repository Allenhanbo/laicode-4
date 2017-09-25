/*
 *
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index i in A such that A[i] is closest to T.
 *
 * Assumptions
 *    There can be duplicate elements in the array, and we can return any of the indices with same value.
 * Examples
 *    A = {1, 2, 3}, T = 2, return 1
 *    A = {1, 4, 6}, T = 3, return 1
 *    A = {1, 4, 6}, T = 5, return 1 or 2
 *    A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 * Corner Cases
 *    What if A is null or A is of zero length? We should return -1 in this case.
 */

public class ClosestInSortedArray {

  // Keep comparing array[mid] with target
  // if array[mid] == target, return mid
  // if array[mid] < target, left = mid;
  // if array[mid] > target, right = mid;
  // until left + 1 == right
  // return the index of left or right, whose value is closer to target

  // Time: O(logn)
  // Space: O(1)
  public int closest(int[] array, int target) {
    // Corner Cases
    if (array == null || array.length == 0) {
      return -1;
    }

    int left = 0, right = array.length - 1;

    // when array[left] < array[right] < target
    // left = mid will cause infinite loop if while (left < right)
    // so we need to stop when left + 1 == right
    while (left + 1 < right) {
      // use left + (right - left) / 2 instead of (left + right) / 2 to avoid overflow
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (Math.abs(target - array[left]) < Math.abs(target - array[right])) {
      return left;
    } else {
      return right;
    }
  }

}
