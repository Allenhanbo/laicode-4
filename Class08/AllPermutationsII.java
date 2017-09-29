/**
 *
 * Given a string with possible duplicate characters,
 * return a list with all permutations of the characters.
 *
 * Examples
 *    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 *    Set = "aba", all permutations are ["aab", "aba", "baa"]
 *    Set = "", all permutations are [""]
 *    Set = null, all permutations are []
 *
 **/

public class AllPermutationsII {

  // Convert string to char array
  // from index 0 to last index, for each index, every unique char can be placed
  // Use a hashset to record every char only be placed on the index once
  // Use dfs to get all permutations

  // Time: O(n!)
  // Space: O(n^2) ~= O(n + n-1 + n-2 + ... + 1)
  public List<String> permutations(String set) {
    List<String> result = new ArrayList<>();
    // Corner case
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    dfs(array, 0, result);
    return result;
  }

  // Helper function: dfs
  private void dfs(char[] array, int index, List<String> result) {
    // base case
    if (index == array.length) {
      result.add(new String(array));
      return;
    }

    // Use hashset to dedup
    Set<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (set.add(array[i])) {
        swap(array, index, i);
        dfs(array, index + 1, result);
        swap(array, index, i);
      }
    }
  }

  // Helper function: swap
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
