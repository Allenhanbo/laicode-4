/**
 *
 * Given an original string input, and two strings S and T,
 * replace all occurrences of S in input with T.
 *
 * Assumptions
 *    input, S and T are not null, S is not empty string
 * Examples
 *    input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 *    input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 *
 **/

public class StringReplace {

  // Use StringBuilder to build the final result
  // Use indexOf(s) to find first index i of s, append all characters before index
  // append t, use indexOf(s) to find next first index of s from i + s.length(), until indexOf(s) return -1

  // Time: O(n)
  // Space: O(n * (t.length() - s.length()) when t.length() > s.length(), else O(n)
  public String replace(String input, String s, String t) {
    // Corner Case
    if (input == null || input.length() == 0) {
      return input;
    }

    StringBuilder sb = new StringBuilder();

    int fromIndex = 0;
    int matchIndex = input.indexOf(s);

    while (matchIndex != -1) {
      sb.append(input, fromIndex, matchIndex).append(t);
      fromIndex = matchIndex + s.length();
      matchIndex = input.indexOf(s, fromIndex);
    }

    sb.append(input, fromIndex, input.length());
    return sb.toString();
  }

}
