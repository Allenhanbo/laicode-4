/**
 *
 * Reverse the words in a sentence.
 *
 * Assumptions
 *    Words are separated by single space
 *    There are no heading or tailing white spaces
 * Examples
 *    “I love Google” → “Google love I”
 * Corner Cases
 *    If the given string is null, we do not need to do anything.
 *
 **/

public class ReverseWordsInASentenceI {

  // Reverse every word in the sentence and reverse the whole string

  // Time: O(n)
  // Space: O(1), assume char[] is in place
  public String reverseWords(String input) {
    // Corner Cases
    if (input == null) {
      return input;
    }

    char[] array = input.toCharArray();

    for (int i = 0; i < array.length; i++) {
      // Skip all leading spaces before a word
      while (i < array.length && array[i] == ' ') {
        i++;
      }
      int start = i;

      // skip all characters to find the end index of a word
      while (i < array.length && array[i] != ' ') {
        i++;
      }
      int end = i - 1;

      // Reverse the word
      reverse(array, start, end);
    }

    // Reverse the whole sentence
    reverse(array, 0, array.length - 1);

    return new String(array);
  }

  // Helper function: reverse
  private void reverse(char[] array, int start, int end) {
    while (start < end) {
      char temp = array[start];
      array[start++] = array[end];
      array[end--] = temp;
    }
  }

}
