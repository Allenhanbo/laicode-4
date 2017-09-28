/**
 *
 *
 *
 *
 *
 **/

public class RemoveCertainCharacters {

  // Build a hash set from String t
  // Start at index 0, only at char from input if set doesn't contain char

  // Time: O(n)
  // Space: O(n)
  public String remove(String input, String t) {
    // Corner Cases
    if (input == null || input.length() == 0) {
      return input;
    }
    Set<Character> set = buildSet(t);
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (!set.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }

  // Helper function: buildSet
  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }

}
