class Solution {
    public void reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int length = nums.length; 
        int r = k%length;
        if(nums != null && length != 1 && r != 0){        
            reverse(nums,0,length-1);
            reverse(nums,0,r-1);
            reverse(nums,r,length-1);
        }
    }
}