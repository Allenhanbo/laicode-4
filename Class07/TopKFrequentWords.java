/**
 *
 * Given a composition with different kinds of words,
 * return a list of the top K most frequent words in the composition.
 *
 * Assumptions
 *    the composition is not null and is not guaranteed to be sorted
 *    K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
 * Return
 *    a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
 * Examples
 *    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
 *    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
 *    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
 *
 **/

 public class TopKFrequentWords {

   // Step 1: Iterate through array and use a hash map to store the counts of each word
  // Step 2: Iterate through hash map and use a size k min heap to store the top k frequent words
  // Step 3: Pop all words from min heap to string[] result

  // Time: O(n + klogk)
  // Space: O(n)
  public String[] topKFrequent(String[] combo, int k) {
    // corner case
    if (combo == null || k <= 0) {
      return new String[0];
    }

    // Step 1
    Map<String, Integer> map = buildHashMap(combo);

    // Step 2
    PriorityQueue<Map.Entry<String, Integer>> minHeap = buildMinHeap(map, k);

    // Step 3
    return getTopKFrequent(minHeap);
  }

  // Helper function: buildHashMap
  private Map<String, Integer> buildHashMap(String[] combo) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : combo) {
      if (!map.containsKey(str)) {
        map.put(str, 1);
      }
      map.put(str, map.get(str) + 1);
    }
    return map;
  }

  // Helper function: buildMinHeap
  private PriorityQueue<Map.Entry<String, Integer>> buildMinHeap (Map<String, Integer> map, int size) {
    PriorityQueue<Map.Entry<String, Integer>> minHeap =
            new PriorityQueue<>(size, new Comparator<Map.Entry<String, Integer>>() {
              @Override
              public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
              }
            });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (minHeap.size() < size) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    return minHeap;
  }

  // Helper function: getTopKFrequent
  private String[] getTopKFrequent(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
    String[] result = new String[minHeap.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = minHeap.poll().getKey();
    }
    return result;
  }

 }
