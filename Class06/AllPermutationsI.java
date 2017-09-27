/**
 *
 * Given a string with no duplicate characters,
 * return a list with all permutations of the characters.
 *
 * Examples
 *    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 *    Set = "", all permutations are [""]
 *    Set = null, all permutations are []
 *
 **/

public class AllPermutationsI {

  // For index i, every char from index i to last index can be put at index i
  // There are O(n!) permutations
  // There are n levels of recursion, for level i, there are n - i options

  // Time: O(n!)
  // Space: O(n), n levels of recursion
  public List<String> permutations(String set) {
    List<String> result = new ArrayList<>();
    // corner case
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

    for (int i = index; i < array.length; i++) {
      // Put char i to index
      swap(array, i, index);
      dfs(array, index + 1, result);
      // Put i back to where it was
      swap(array, i, index);
    }
  }

  // Helper function: swap
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
