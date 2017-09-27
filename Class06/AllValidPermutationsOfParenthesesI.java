/**
 *
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 *
 * Assumptions
 *    N >= 0
 * Examples
 *    N = 1, all valid permutations are ["()"]
 *    N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 *    N = 0, all valid permutations are [""]
 *
 **/

public class AllValidPermutationsOfParenthesesI {

  // Always try to add '(' first if possible
  // then try to add ')' if possible and valid
  // n levels of recursion tree, each level has two children, add left and add right

  // Time: O(2^n)
  // Space: O(n), n levels of recursion tree
  public List<String> validParentheses(int n) {
    List<String> result = new ArrayList<>();
    // corner case
    if (n == 0) {
      result.add("");
      return result;
    }
    char[] array = new char[2 * n];
    dfs(array, 0, n, n, result);
    return result;
  }

  // Helper function: dfs
  private void dfs(char[] array, int index, int left, int right, List<String> result) {
    if (index == array.length) {
      result.add(new String(array));
      return;
    }

    // if possible to add left parentheses
    if (left > 0) {
      array[index] = '(';
      dfs(array, index + 1, left - 1, right, result);
    }

    // Only when more left are added is the valid time to add right parentheses
    if (right > left) {
      array[index] = ')';
      dfs(array, index + 1, left, right - 1, result);
    }
  }

}
