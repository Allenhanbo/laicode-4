/**
 *
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 *
 * Assumptions:
 *    The given string is not null.
 * Examples:
 *    “  a” --> “a”
 *    “   I     love MTV ” --> “I love MTV”
 *
 **/

public class RemoveSpaces {

  // Remove leading spaces and duplicate spaces between words
  // Remove trailing space if exists

  // Time: O(n)
  // Space: O(1)
  public String removeSpaces(String input) {
    // Corner Cases
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      // Remove leading spaces and duplicate spaces
      if (array[fast] == ' ' && (fast == 0 || array[fast] == array[fast - 1])) {
        continue;
      }
      array[slow++] = array[fast];
    }
    // array[slow - 1] could be a space
    if (slow > 0 && array[slow - 1] == ' ') {
      return new String(array, 0, slow - 1);
    }
    return new String(array, 0, slow);
  }

}
