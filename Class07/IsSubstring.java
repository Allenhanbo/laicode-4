/**
 *
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string.
 * Return -1 if the small string is not a substring of the large string.
 *
 * Assumptions
 *    Both large and small are not null
 *    If small is empty string, return 0
 * Examples
 *    “ab” is a substring of “bcabc”, return 2
 *    “bcd” is not a substring of “bcabc”, return -1
 *    "" is substring of "abc", return 0
 *
 **/

public class IsSubstring {

  // Start with index 0 to large.length() - small.length(), start checking whether small match

  // Time: O(n * m)
  // Space: O(1)
  public int strstr(String large, String small) {
    // Corner Case
    if (small.length() == 0) {
      return 0;
    } else if (small.length() > large.length()) {
      return - 1;
    }

    for (int i = 0; i <= large.length() - small.length(); i++) {
      if (checkEqual(large, i, small)) {
        return i;
      }
    }

    return -1;
  }

  // Helper function: checkEqual
  private boolean checkEqual(String large, int index, String small) {
    for (int i = 0; i < small.length(); i++) {
      if (large.charAt(i + index) != small.charAt(i)) {
        return false;
      }
    }
    return true;
  }

}
