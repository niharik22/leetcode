class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j]; 
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        if(nums != null && nums.length >1) {
        int left =0;
        int right = 1;
        while(right<nums.length){
            if(nums[left] == 0 && nums[right]!=0){
                swap(nums, left, right);
                left++;
                right++;
            } else if(nums[left] == 0 && nums[right]==0){
                right++;
            } else{
            left++;
            right++;
            }
        }
     }
    }
}