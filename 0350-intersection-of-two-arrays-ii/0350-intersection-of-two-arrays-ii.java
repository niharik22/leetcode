class Solution {
    
    public HashMap<Integer, Integer> helper (int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int n : nums){
           counter.put(n,counter.getOrDefault(n,0)+1);
        }
        return counter;
    } 
    public int[] intersect(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> result = new ArrayList<>(); 
        HashMap<Integer, Integer> n1Freq = helper(nums1);
        HashMap<Integer, Integer> n2Freq = helper(nums2);
        for(int key : n1Freq.keySet()){
            if(n2Freq.containsKey(key)){
                int repeat = Math.min(n1Freq.get(key),n2Freq.get(key));
                for(int i = 0; i<repeat;i++){
                    result.add(key);
                }
            }
        }
         int[] intersection = result.stream().filter(i -> i != null).mapToInt(i -> i).toArray();    
        return intersection;
    }
}