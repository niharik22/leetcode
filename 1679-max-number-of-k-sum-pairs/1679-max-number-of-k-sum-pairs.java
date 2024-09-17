class Solution {
    public int maxOperations(int[] nums, int k) {
        int count =0;
        Map<Integer,Integer> pairs = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int complement = k-nums[i];
            if(pairs.containsKey(complement)){
                count++;
                int repeat = pairs.get(complement);
                if(repeat<=1){
                     pairs.remove(complement);
                }else{
                    pairs.put(complement,repeat-1);
                }
            }else{
                pairs.put(nums[i], pairs.getOrDefault(nums[i],0) + 1 );
            }
        }
        return count;
    }
}