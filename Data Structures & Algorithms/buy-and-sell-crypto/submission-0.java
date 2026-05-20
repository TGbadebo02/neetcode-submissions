class Solution {
    public int maxProfit(int[] prices) {
        //set base case for invalid array size.
        if(prices.length == 0 ||prices.length > 100) return 0;

        int maxProfit = 0;

        for(int i = 0; i < prices.length - 1; i++){
            
            for(int j = i + 1; j < prices.length; j++){
                
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);

            }
        }

        return maxProfit;
    }
}
