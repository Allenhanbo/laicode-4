/**
 *
 * Reverse a given string.
 *
 * Assumptions
 *    The given string is not null.
 *
 **/

public class ReverseString {

  // Two pointers, start and end, reverse them and start++, end--

  // Time: O(n)
  // Space: O(1), assume char[] is in place
  public String reverse(String input) {
    // Corner Case
    if (input == null) {
      return null;
    }

    char[] array = input.toCharArray();
    int start = 0, end = array.length - 1;

    while (start < end) {
      char temp = array[start];
      array[start++] = array[end];
      array[end--] = temp;
    }

    return new String(array);
  }

}
