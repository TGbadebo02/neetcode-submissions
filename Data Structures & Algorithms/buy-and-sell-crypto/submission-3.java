class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length > 100) return 0;

        int maxProfit = 0;
        int buy = 0;

        for (int sell = 0; sell < prices.length - 1; sell++) {
            while(prices[buy] > prices[sell]){
                buy++;
            }
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
        }

        return maxProfit;
    }
}
