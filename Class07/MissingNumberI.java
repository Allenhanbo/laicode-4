/**
 *
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one,
 * find the missing number.
 *
 * Assumptions
 *    The given array is not null, and N >= 1
 * Examples
 *    A = {2, 1, 4}, the missing number is 3
 *    A = {1, 2, 3}, the missing number is 4
 *    A = {}, the missing number is 1
 *
 **/

public class MissingNumberI {

  // Use XOR to xor from 1 to N
  // Then xor through array
  // the result is the missing number

  // Time: O(n)
  // Space: O(1)
  public int missing(int[] array) {
    // Corner case
    if (array == null || array.length == 0) {
      return 1;
    }

    int N = array.length + 1;
    int result = 0;
    for (int i = 1; i <= N; i++) {
      result ^= i;
    }

    for (int num : array) {
      result ^= num;
    }

    return result;
  }

}
