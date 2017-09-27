/**
 *
 * Find the K smallest numbers in an unsorted integer array A.
 * The returned numbers should be in ascending order.
 *
 * Assumptions
 *    A is not null
 *    K is >= 0 and smaller than or equal to size of A
 * Return
 *    an array with size K containing the K smallest numbers in ascending order
 * Examples
 *    A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 *
 **/

public class KSmallestUnsortedArray {

  // Solution 1: min heap
  // Time: O(n + nlogn + klogn)
  // Space: O(n)
  public int[] kSmallestMinHeap(int[] array, int k) {
    // Corner Case
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    int[] result = new int[k];
    // Use min heap to provide smallest number at every poll
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // store all numbers of array into min heap
    for (int num : array) {
      minHeap.offer(num);
    }
    // Poll k smallest numbers of min heap
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll();
    }
    return result;
  }

  // Solution 2: max heap
  // Time: O(n + nlogk + klogk)
  // Space: O(k)
  public int[] kSmallestMaxHeap(int[] array, int k) {
    // Corner Case
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    int[] result = new int[k];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    // iterate through the array, store smallest k numbers in max heap
    for (int num : array) {
      if (maxHeap.size() < k) {
        maxHeap.offer(num);
      } else if (num < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(num);
      }
    }
    // Store numbers from max heap to result array from largest to smallest
    for (int i = k - 1; i >= 0; i--) {
      result[i] = maxHeap.poll();
    }
    return result;
  }

  // Solution 3: quick select
  // Time: Average O(n + klogk), worst O(n^2 + klogk) : select n times, and each select take O(n)
  // Space: Average O(logn), worst: O(n)
  public int[] kSmallestQuickSelect(int[] array, int k) {
    // Corner Case
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    quickSelect(array, 0, array.length - 1, k - 1);
    int[] result = Arrays.copyOf(array, k);
    Arrays.sort(result);
    return result;
  }

  // Helper function: quickSelect
  private void quickSelect(int[] array, int left, int right, int k) {
    int pivotIndex = partition(array, left, right);
    if (pivotIndex == k) {
      return;
    } else if (pivotIndex < k) {
      quickSelect(array, pivotIndex + 1, right, k);
    } else {
      quickSelect(array, left, pivotIndex - 1, k);
    }
  }

  // Helper function: partition
  private int partition(int[] array, int left, int right) {
    int pivotIndex = new Random().nextInt(right - left + 1) + left;
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);
    int leftBound = left, rightBound = right - 1;
    while (leftBound <= rightBound) {
      if (array[leftBound] < pivot) {
        leftBound++;
      } else if (array[rightBound] >= pivot) {
        rightBound--;
      } else {
        swap(array, leftBound++, rightBound--);
      }
    }
    swap(array, right, leftBound);
    return leftBound;
  }

  // Helper function: swap
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
