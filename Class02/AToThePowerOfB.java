/**
 *
 * Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.
 *
 * Examples
 *    power(2, 0) = 1
 *    power(2, 3) = 8
 *    power(0, 10) = 0
 *    power(-2, 5) = -32
 * Corner Cases
 *    What if the result is overflowed? We can assume the result will
 *    not be overflowed when we solve this problem on this online judge.
 */

public class AToThePowerOfB {

  // To get a^b, calculate a^(b/2) first, 
  // if b is even number, a^b = a^(b/2) * a^(b/2)
  // if b is odd number,  a^b = a^(b/2) * a^(b/2) * a

  // Time: O(logn)
  // Space: O(logn)
  public long power(int a, int b) {

    // Assumption: Both a and b are non-negative numbers

    // Corner Cases
    if (a == 0) {
      return 0L;
    } else if (b == 0) {
      return 1L;
    }

    long half = power(a, b / 2);

    if (b % 2 == 0) {
      return half * half;
    } else {
      return half * half * a;
    }
  }

}
