class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int n = nums.length;
        
        //INCORRECT USING THE SAME DP ARRAY.
        //return Math.max(dfs(0, n - 2, nums, dp), dfs(1, n - 1, nums, dp));

        int includeLast = dfs(0,n - 2, nums, new Integer[n]);
        int excludeLast = dfs(1,n - 1, nums, new Integer[n]);

        return Math.max(includeLast,excludeLast);
    }

    public int dfs(int i, int end, int[] nums, Integer[] dp) {
        if (i > end)
            return 0;

        if (dp[i] != null)
            return dp[i];

        dp[i] = Math.max((nums[i] + dfs(i + 2, end, nums, dp)), dfs(i + 1, end, nums, dp));

        return dp[i];
    }
}
