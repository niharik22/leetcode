class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int size = prices.length;
        int max = prices[size-1];
        for(int i = size-1; i>=0; i--){
           maxProfit = Integer.max( max - prices[i], maxProfit);
           max = Integer.max(max,prices[i]);
        }
        
        return maxProfit;
    }
}