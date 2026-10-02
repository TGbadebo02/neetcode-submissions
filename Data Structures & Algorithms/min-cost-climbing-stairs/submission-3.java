class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int memo1[] = new int[n];
        Arrays.fill(memo1, -1);
        int memo2[] = new int[n];
        Arrays.fill(memo2, -1);

        int min1 = dp(0, cost, 0, memo1);
        int min2 = dp(1, cost, 0, memo2);

        return Math.min(min1, min2);
    }

    public int dp(int i, int[] cost, int total, int[] memo) {
        if (i >= cost.length) {
            return total;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int floor1 = dp(i + 1, cost, total, memo);
        int floor2 = dp(i + 2, cost, total, memo);

        memo[i] = cost[i] + Math.min(floor1, floor2);
        return memo[i];
    }
}
