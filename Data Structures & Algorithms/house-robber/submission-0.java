class Solution {
    public int rob(int[] nums) {
        Integer [] memo = new Integer[nums.length];

        int house = dp(0,nums,memo);
        int skipHouse = dp(1,nums,memo);

        return Math.max(house,skipHouse);
    }

    public int dp(int i, int [] nums, Integer [] memo){
        if(i >= nums.length) return 0;

        if(memo[i] != null) return memo[i];

        memo[i] = nums[i] + dp(i + 2, nums, memo);

        return memo[i];
    }
}
