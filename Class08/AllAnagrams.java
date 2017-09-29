/**
 *
 * Find all occurrence of anagrams of a given string s in a given string l.
 * Return the list of starting indices.
 *
 * Assumptions
 *    s is not null or empty.
 *    l is not null.
 * Examples
 *    l = "abcbac", s = "ab", return [0, 3]
 *    since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 *
 **/

public class AllAnagrams {

  // Use a hash map to store the characters and counts of the characters
  // Sliding window with length of s
  // Iterate through string l, match = 0
  // get char c at index i, get count of char c in map
  // if count != null, decrement count of c in map
  //    if count == 1 before decrement, match ++
  // when i >= s.length, after decrement count of c in map,
  //    get char at i - s.length(), which is the char that moves out of sliding window, and count of c in map
  //    if count != null, increment count of c in map
  //      if count == 0 before increment, match--
  // if match == map.size, add i - s.length() + 1 to result

  // Time: O(n)
  // Space: O(n)
  public List<Integer> allAnagrams(String s, String l) {
    List<Integer> result = new ArrayList<>();
    // Corner Case
    if (s == null || l == null || l.length() == 0 || s.length() == 0 || s.length() > l.length()) {
      return result;
    }

    // Store the character, count pair in String s
    Map<Character, Integer> map = buildMap(s);

    int match = 0;
    for (int i = 0; i < l.length(); i++) {
      char c = l.charAt(i);
      Integer count = map.get(c);

      if (count != null) {
        if (count == 1) {
          match++;
        }
        map.put(c, count - 1);
      }

      if (i >= s.length()) {
        c = l.charAt(i - s.length());
        count = map.get(c);
        if (count != null) {
          if (count == 0) {
            match--;
          }
          map.put(c, count + 1);
        }
      }

      if (match == map.size()) {
        result.add(i - s.length() + 1);
      }
    }

    return result;
  }

  // Helper function: buildMap
  private Map<Character, Integer> buildMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer count = map.get(c);
      if (count != null) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    return map;
  }

}
