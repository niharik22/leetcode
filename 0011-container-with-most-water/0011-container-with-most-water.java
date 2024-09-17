class Solution {
    public int maxArea(int[] height) {
        int l = height.length;
        int i = 0;
        int j = l - 1;
        int maxArea = 0;
        
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        
        return maxArea;
    }
}