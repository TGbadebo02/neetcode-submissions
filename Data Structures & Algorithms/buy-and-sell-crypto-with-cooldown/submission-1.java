class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        
        int n = prices.length;

        Integer [] memo = new Integer[n];
        return recursion(0, prices, memo);
    }

    public int recursion(int i, int [] nums, Integer [] memo){
        if(i >= nums.length) return 0;
        
        if(memo[i]!= null) return memo[i];
        
        int maxProfit = 0;

        for(int buy = i; buy < nums.length; buy++){
            for(int sell = buy + 1; sell < nums.length; sell++){
                int profit = nums[sell] - nums[buy];
                int cndidte = profit + recursion(sell + 2, nums, memo);
                maxProfit = Math.max(cndidte, maxProfit);
                
            }
        }

        return memo[i] = maxProfit;
    }
}
