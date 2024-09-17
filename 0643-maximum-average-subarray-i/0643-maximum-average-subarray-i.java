class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int i = 0;
        int j = 0;
        double avg=Integer.MIN_VALUE;
        int length = nums.length;
        double sum = 0;

        while(j<length){
            sum += nums[j];
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                double avg1 = (sum)/k;
                avg = Math.max(avg1,avg);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        return avg;
    }
}