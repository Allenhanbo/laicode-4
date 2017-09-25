/**
 *
 * Given a integer dictionary A of unknown size,
 * where the numbers in the dictionary are sorted in ascending order,
 * determine if a given target integer T is in the dictionary.
 * Return the index of T in A, return -1 if T is not in A.
 *
 * Assumptions
 *    dictionary A is not null
 *    dictionary.get(i) will return null(Java)/INT_MIN(C++) if index i is out of bounds
 * Examples
 *    A = {1, 2, 5, 9, ......}, T = 5, return 2
 *    A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 *
 **/

public class SearchInUnknownSizedSortedArray {

  static class Dictionary {
    List<Integer> dict;
    Dictionary(int[] array) {
      dict = new ArrayList<>();
      for (int num : array) {
        dict.add(num);
      }
    }
    public Integer get(int index) {
      return index;
    }
  }

  // Start with left = 0, right = 1;
  // while (dict.get(right) != null && dict.get(right) < target)
  // left = right, right *= 2;
  // Then, the target must be in the range of (left, right]
  // Then use binary search in (left, right]

  // Time: O(logn)
  // Space: O(1)
  public int search(Dictionary dict, int target) {
    // Corner cases
    if (dict == null) {
      return -1;
    }

    int left = 0, right = 1;

    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right *= 2;
    }

    // Start binary search in range of (left, right]
    while (left <= right) {
      // Use left + (right - left) / 2 to avoid overflow
      int mid = left + (right - left) / 2;
      Integer value = dict.get(mid);
      if (value == null || value > target) {
        right = mid - 1;
      } else if (value == target) {
        return mid;
      } else {
        left = mid + 1;
      }
    }

    // target not found
    return -1;
  }

}
