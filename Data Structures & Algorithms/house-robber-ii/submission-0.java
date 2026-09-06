class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(dfs(0, true, nums), dfs(1, false, nums));
    }

    public int dfs(int i, boolean flag, int [] nums){
        if(i >= nums.length || flag && i == nums.length - 1) return 0;

    return Math.max((nums[i] + dfs(i + 2, flag || i == 0, nums)), dfs(i + 1, flag, nums));

    }
}
