/*
 *
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index of the last occurrence of T in A or return -1 if there is no such index.
 *
 * Assumptions
 *    There can be duplicate elements in the array.
 * Examples
 *    A = {1, 2, 3}, T = 2, return 1
 *    A = {1, 2, 3}, T = 4, return -1
 *    A = {1, 2, 2, 2, 3}, T = 2, return 3
 * Corner Cases
 *    What if A is null or A is array of zero length? We should return -1 in this case.
 */

public class LastOccurrence {

  // Keep comparing array[mid] with target,
  // if array[mid] == target, left = mid;
  // if array[mid] < target, left = mid + 1;
  // if array[mid] > target, right = mid - 1;
  // until left + 1 == right
  // if array[right] == target, return right
  // return array[left] == target ? left : -1;

  // Time: O(logn)
  // Space: O(1)
  public int lastOccur(int[] array, int target) {
    // Corner Cases
    if (array == null || array.length == 0) {
      return -1;
    }

    int left = 0, right = array.length - 1;

    // if use while (left < right),
    // when array[left] == target && array[right] == target, will infinite loop
    // so we need to stop when left + 1 == right
    while (left + 1 < right) {
      // left + (right - left) / 2 instead of (left + right) / 2 to avoid overflow
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // Check array[right] first
    if (array[right] == target) {
      return right;
    }

    return array[left] == target ? left : -1;
  }

}
