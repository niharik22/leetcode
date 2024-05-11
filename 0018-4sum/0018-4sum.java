class Solution {

     public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i = start; i< nums.length; i++ ){
            int compliment = (int) target - nums[i];
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != nums[i]){
            if(s.contains(compliment)){
                List<Integer> subResult = new ArrayList<>();
                subResult.add(compliment);
                subResult.add(nums[i]);  
                result.add(subResult);
            }
            }
            s.add(nums[i]);
        }
        return result;
     }
     
     public List<List<Integer>> kSum(int[] nums, long target, int start, int k){
        List<List<Integer>> result = new ArrayList<>();
        
        // if we run out of numbers, return result
        if(start == nums.length){
            return result;
        }

        // K remaining values to add to the sum
        // average of these values is least target/k
        long average_value = target/k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if(nums[start]>average_value || nums[nums.length - 1]< average_value){
            return result;
        }

        if (k==2){
            return twoSum(nums, target, start);
        }

        for(int i = start; i< nums.length; i++){
            if(i == start || nums[i-1]!=nums[i]){
                List<List<Integer>> kSumResult = kSum(nums, target - nums[i], i+1, k-1 ); 
                    for(List<Integer> subset : kSumResult){
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                    }
            }
        }
        return result;
     }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
}