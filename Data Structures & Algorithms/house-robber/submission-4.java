class Solution {
    public int rob(int[] nums) {
        int memo [] = new int[nums.length];
        Arrays.fill(memo,-1);

        return dp(0, nums, 0, memo);
    }

    public int dp(int i, int [] nums, int total, int [] memo){
        if(i >= nums.length) return 0;

        if(memo[i] != -1) return memo[i];

        int curHouse = nums[i] + dp(i + 2, nums, total, memo);

        int skipHouse = dp(i + 1, nums, total, memo);

        memo[i] = Math.max(curHouse,skipHouse);
        return memo[i];
    }
}
