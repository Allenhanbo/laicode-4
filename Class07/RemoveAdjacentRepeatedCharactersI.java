/**
 *
 * Remove adjacent, repeated characters in a given string,
 * leaving only one character for each group of such characters.
 *
 * Assumptions
 *    Try to do it in place.
 * Examples
 *    “aaaabbbc” is transferred to “abc”
 * Corner Cases
 *    If the given string is null, we do not need to do anything.
 *
 **/

public class RemoveAdjacentRepeatedCharacterI {

  // Since can leave one repeated character,
  // slow pointer starts at index 1, fast pointer starts at index 1
  // Skip all char at fast that is same as char at slow-1
  // only add char at fast to slow index when the chars are different

  // Time: O(n)
  // Space: O(1)
  public String deDup(String input) {
    // Corner Cases
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int slow = 1;
    for (int fast = 1; fast < array.length; fast++) {
      if (array[fast] != array[slow - 1]) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }

}
