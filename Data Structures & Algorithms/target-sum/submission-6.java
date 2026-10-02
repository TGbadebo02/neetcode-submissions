class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int [] memo = new int[nums.length];
        return findWays(0, 0, nums, target, memo);
    }

    public int findWays(int i, int total, int[] nums, int target, int [] memo) {
        if (i == nums.length) {
            if (total == target) {
                return 1;
            } else {
                return 0;
            }
        }

        memo[i] =  findWays(i + 1, total + nums[i], nums, target, memo)
            + findWays(i + 1, total - nums[i], nums, target, memo);
        return memo[i];
    }
}
