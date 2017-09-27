/**
 *
 * Given a set of characters represented by a String,
 * return a list containing all subsets of the characters.
 *
 * Assumptions
 *     There are no duplicate characters in the original set.
 * ​Examples
 *    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 *    Set = "", all the subsets are [""]
 *    Set = null, all the subsets are []
 *
 **/

public class AllSubsetsI {

  // Each character can either be in the subset or not
  // For the recursion tree, the height is string.length
  // level i represents ith character,
  // left child represents ith char not in the subset
  // right child represents ith char in the subset
  // There are 2^n subsets

  // Time: O(2^n)
  // Space: O(n), height of recursion tree
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    // Corner Case
    if (set == null) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    char[] array = set.toCharArray();
    dfs(array, 0, sb, result);
    return result;
  }

  // Helper function: dfs
  // DFS solution 1
  private void dfs(char[] array, int index, StringBuilder sb, List<String> result) {
    // base case
    if (index == array.length) {
      result.add(sb.toString());
      return;
    }

    // add ith char into subset
    sb.append(array[index]);
    dfs(array, index + 1, sb, result);
    // back track, remove ith char
    sb.deleteCharAt(sb.length() - 1);
    // don't add ith char into subset
    dfs(array, index + 1, sb, result);
  }

  // Helper function: dfs2
  // DFS solution 2
  private void dfs2(char[] array, int index, StringBuilder sb, List<String> result) {
    // Add current sb's value to result
    result.add(sb.toString());

    for (int i = index; i < array.length; i++) {
      // Add array[i] to sb
      sb.append(array[i]);
      dfs2(array, i + 1, sb, result);
      // Don't add array[i] to sb
      sb.deleteCharAt(sb.length() - 1);
    }
  }

}
