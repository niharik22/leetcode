class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
         if (length <= 2) return length;
        int l = 2;        
       for (int r = 2; r < nums.length; r++) {
            // Compare current element with the element at l-2
            if (nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}