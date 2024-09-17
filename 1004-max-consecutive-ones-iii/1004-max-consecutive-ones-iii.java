class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = nums.length;
        int right = 0;
        int left = 0;
        int maxOnes = 0;
        int zeroCount = 0;

        while(right<l){
            if(nums[right]==0){
                zeroCount++;
            }
            
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxOnes = Integer.max(maxOnes, right - left + 1);
            right++;
        }
        return maxOnes;
    }
}