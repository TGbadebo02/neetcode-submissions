class Solution {
    int minCost = 0;
    public int minCostClimbingStairs(int[] cost) {
        Integer [] dp = new Integer[cost.length];

        int frstStp = recursiveHelper(0,cost,dp);
        int sndStp = recursiveHelper(1,cost,dp);

        return Math.min(frstStp,sndStp);
    }

    public int recursiveHelper(int i, int [] cost, Integer [] dp){
        //base case.
        if(i >= cost.length){
            return 0;
        }

        if(dp[i] != null) return dp[i];

        int step1 = cost[i] + recursiveHelper(i + 1, cost, dp);
        int step2 = cost[i] + recursiveHelper(i + 2, cost, dp);

        dp[i] = Math.min(step1, step2);

        return dp[i];

    }
}
