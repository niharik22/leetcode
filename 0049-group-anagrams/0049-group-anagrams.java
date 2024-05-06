class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
        // Check for null or empty input array
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Create a hashmap to group the anagrams
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            
            // If key does not exist in map, create a new entry
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Add the original string to the list associated with the sorted key
            map.get(key).add(s);
        }
        
        // Return the grouped anagrams
        return new ArrayList<>(map.values());
    }
}