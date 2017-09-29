/**
 *
 * Given a string in compressed form, decompress it to the original string.
 * The adjacent repeated characters in the original string are compressed
 * to have the character followed by the number of repeated occurrences.
 *
 * Assumptions
 *    The string is not null
 *    The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 *    There are no adjacent repeated characters with length > 9
 * Examples
 *    “a1c0b2c4” → “abbcccc”
 *
 **/

public class DecompressStringII {

  // Since there are no ajacent repeated characters with length > 9
  // We can read two char at a time, first char is the letter, second char is the count
  // iterate the input string to build new string with string builder

  // Time: O(n)
  // Space: O(n), size of StringBuilder
  public String decompress(String input) {
    // Corner Case
    if (input == null || input.length() == 0) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      i++;
      int count = input.charAt(i) - '0';
      for (int j = 0; j < count; j++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}
