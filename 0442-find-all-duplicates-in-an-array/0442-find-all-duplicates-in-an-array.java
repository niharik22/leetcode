class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> duplicates = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;  // Convert number to index
        if (nums[index] < 0) {
            duplicates.add(Math.abs(nums[i]));  // It's a duplicate
        } else {
            nums[index] = -nums[index];  // Mark this index as visited
        }
    }

    return duplicates;
    }
}