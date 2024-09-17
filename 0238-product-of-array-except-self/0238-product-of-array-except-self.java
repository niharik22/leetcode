class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            if(i==0){
                result[i]=1;
            }else{
            prod *= nums[i-1]; 
            result[i] = prod;
            }
        }
        prod = 1;
        for(int i = nums.length-2; i>=0;i--){
            prod *= nums[i+1];
            result[i]=result[i]*prod;
        }
        return result;
    }
}