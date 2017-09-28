/**
 *
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 * No adjacent characters should be identified in the final string.
 *
 * Examples
 *    "abbbaaccz" → "aaaccz" → "ccz" → "z"
 *    "aabccdc" → "bccdc" → "bdc"
 *
 **/

public class RemoveAdjacentRepeatedCharactersIV {

  // Since no adjacent characters are allowed
  // slow index starts at index -1, fast index starts at index 0
  // Add array[fast] when array[fast] != array[slow]
  // skip all array[fast] if array[fast] == array[slow]

  // Time: O(n)
  // Space: O(1)
  public String deDup(String input) {
    // Corner Cases
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int slow = -1;
    for (int fast = 0; fast < array.length; fast++) {
      int start = fast;
      if (slow == -1 || array[fast] != array[slow]) {
        array[++slow] = array[fast];
      } else {
        while (fast + 1 < array.length && array[fast + 1] == array[fast]) {
          fast++;
        }
        slow--;
      }
    }
    return new String(array, 0, slow + 1);
  }

}
