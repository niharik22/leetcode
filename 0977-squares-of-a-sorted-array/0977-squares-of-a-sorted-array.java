class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        
        int left = 0;
        int right = l-1;
        int j = l-1;
        while(left<=right){
            int sL = nums[left]*nums[left];
            int sR = nums[right]*nums[right];
            if(sL<=sR){
                result[j]=sR;
                right--;
                j--;
            }else{
                result[j]=sL;
                left++;
                j--;
            }
        }
        return result;
    }
}