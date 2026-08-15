class Solution {
    public int rob(int[] nums) {
        Integer [] memo = new Integer[nums.length];

        return dp(0,nums,memo);

    }

    public int dp(int i, int [] nums, Integer [] memo){
        if(i >= nums.length) return 0;

        if(memo[i] != null) return memo[i];


        int curHouse = nums[i] + dp(i + 2, nums, memo);
        int skipHouse = dp(i + 1, nums, memo);

        memo[i] = Math.max(curHouse, skipHouse);
    
        return memo[i];
    }
}
