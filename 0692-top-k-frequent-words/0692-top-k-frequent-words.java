class Solution {
   public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String s : words) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        // Step 2: Use a priority queue to get the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>((word1, word2) -> {
            int freq1 = freqMap.get(word1);
            int freq2 = freqMap.get(word2);
            if (freq1 == freq2) {
                return word1.compareTo(word2); // Ascending lexicographical order
            }
            return freq2 - freq1; // Descending order by frequency
        });

        // Add all words to the priority queue
        pq.addAll(freqMap.keySet());

        // Step 3: Extract the top k words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}