/**
 *
 * Find all numbers that appear in both of two sorted arrays
 * (the two arrays are all sorted in ascending order).
 *
 * Assumptions
 *    In each of the two sorted arrays, there could be duplicate numbers.
 *    Both two arrays are not null.
 * Examples
 *    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 *
 **/

public class CommonNumbersOfTwoSortedArray {

  // Let ai and bi start at listA and listB
  // put common number into result list
  // if not common, move smaller value's index forward

  // Time: O(n)
  // Space: O(1)
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<>();
    // Corner case
    if (A == null || B == null) {
      return result;
    }
    int ai = 0, bi = 0;
    while (ai < A.size() && bi < B.size()) {
      if (A.get(ai) == B.get(bi)) {
        result.add(A.get(ai));
        ai++;
        bi++;
      } else if (A.get(ai) < B.get(bi)) {
        ai++;
      } else {
        bi++;
      }
    }
    return result;
  }

}
