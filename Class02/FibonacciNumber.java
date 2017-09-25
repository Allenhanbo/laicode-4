/**
 *
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed,
 * the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 *
 * Examples
 *    0th fibonacci number is 0
 *    1st fibonacci number is 1
 *    2nd fibonacci number is 1
 *    3rd fibonacci number is 2
 *    6th fibonacci number is 8
 * Corner Cases
 *    What if K < 0? in this case, we should always return 0.
 *    Is it possible the result fibonacci number is overflowed? We can assume
 *    it will not be overflowed when we solve this problem on this online judge,
 *    but we should also know that it is possible to get an overflowed number,
 *    and sometimes we will need to use something like BigInteger.
 *
 */

public class FibonacciNumber {

  // fibo(n) = fibo(n - 1) + fibo(n - 2)
  // We just need to store prev = fibo(n - 1) and prevPrev = fibo(n - 2)
  // long temp = prev + prevPrev; prevPrev = prev; prev = cur;
  // we just need to always return prev;

  // Time: O(n)
  // Space: O(1)
  public long fibonacci(int K) {
    // Corner Cases
    if (K <= 0) {
      return 0L;
    }

    long prevPrev = 0L;
    long prev = 1L;

    while (K > 1) {
      long cur = prevPrev + prev;
      prevPrev = prev;
      prev = cur;
      K--;
    }

    return prev;
  }
}
