class Solution {
   private Integer[][] memo;

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];

        // Start on day 0 without owning a stock.
        return dfs(0, 0, prices);
    }

    private int dfs(int i, int holding, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][holding] != null) {
            return memo[i][holding];
        }

        int result;

        if (holding == 0) {
            int skip = dfs(i + 1, 0, prices);
            int buy = -prices[i] + dfs(i + 1, 1, prices);

            result = Math.max(skip, buy);
        } else {
            int keepHolding = dfs(i + 1, 1, prices);
            int sell = prices[i] + dfs(i + 2, 0, prices);

            result = Math.max(keepHolding, sell);
        }

        return memo[i][holding] = result;
    }
}
