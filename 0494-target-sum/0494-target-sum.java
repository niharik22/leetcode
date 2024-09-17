class Solution {
    int ways = 0;
    int target;
    
    public int findTargetSumWays(int[] nums, int target) {  
        this.target = target;
        findTargetSum(nums, 0, 0);
        return ways;
    }
    
    private void findTargetSum(int[] nums, int cur, int sum) {
        
        if (cur == nums.length) {
            if (sum == target) {
                ways++;
            }
            return;
        }
        
        findTargetSum(nums, cur + 1, sum + nums[cur]);
        findTargetSum(nums, cur + 1, sum - nums[cur]);
    }
}