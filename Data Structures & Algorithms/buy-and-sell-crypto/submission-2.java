class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length > 100) return 0;

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int buy = prices[i]; 
                int sell = prices[j];

                maxProfit = Math.max(maxProfit, sell - buy);
            }
        }

        return maxProfit;
    }
}
