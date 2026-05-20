class Solution {
    public int maxProfit(int[] prices) {
        //set the base case.
        if(prices.length == 0 || prices.length >= 100)return 0;

        int buyDay = 0;
        int maxProfit = 0;

        for(int sellDay = 1; sellDay < prices.length; sellDay++){

            while(prices[buyDay] > prices[sellDay]){
                
                buyDay++;
            }
            
             int profit = prices[sellDay] - prices[buyDay];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
