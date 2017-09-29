/**
 *
 * Given a string, find the longest substring without any repeating characters
 * and return the length of it. The input string is guaranteed to be not null.
 *
 * Example
 *    the longest substring without repeating letters for "bcdfbd" is "bcdf",
 *    we should return 4 in this case.
 *
 **/

public class LongestSubstringWithoutRepeatingCharacters {

  // Use a hash set to store the characters of substring
  // When the next char is unique, add it to hash set, and record the max length
  // When the next char is not unique, remove the char at start of substring,
  // increment start index, until the next char is unique in substring,

  // Time: O(n)
  // Space: O(n)
  public int longest(String input) {
    // Corner Case
    if (input == null || input.length() == 0) {
      return 0;
    }
    Set<Character> set = new HashSet<>();
    int maxLen = 1;
    int start = 0, end = 0;
    while (end < input.length()) {
      if (set.add(input.charAt(end))) {
        end++;
        maxLen = Math.max(maxLen, end - start);
      } else {
        set.remove(input.charAt(start++));
      }
    }
    return maxLen;
  }

}
