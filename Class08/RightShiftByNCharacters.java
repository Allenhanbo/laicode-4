/**
 *
 * Right shift a given string by n characters.
 *
 * Assumptions
 *    The given string is not null.
 *    n >= 0.
 *
 **/

public class RightShiftByNCharacters {

  // Get actual shift distance by N = n % input.length()
  // reverse 0 ~ input.length() - N - 1, reverse input.length() - N ~ input.length() - 1
  // reverse whole string

  // Time: O(n)
  // Space: O(1)
  public String rightShift(String input, int n) {
    // Corner Case
    if (input == null || input.length() == 0 || n == 0 || n % input.length() == 0) {
      return input;
    }

    int N = n % input.length();
    char[] array = input.toCharArray();

    reverse(array, 0, array.length - N - 1);
    reverse(array, array.length - N, array.length - 1);
    reverse(array, 0, array.length - 1);

    return new String(array);
  }

  // helper function: reverse
  private void reverse(char[] array, int start, int end) {
    while (start < end) {
      char temp = array[start];
      array[start++] = array[end];
      array[end--] = temp;
    }
  }

}
