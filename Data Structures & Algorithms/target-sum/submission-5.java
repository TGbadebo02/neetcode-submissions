class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findWays(0, 0, nums, target);
    }

    public int findWays(int i, int total, int[] nums, int target) {
        if (i == nums.length) {
            if (total == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return findWays(i + 1, total + nums[i], nums, target)
            + findWays(i + 1, total - nums[i], nums, target);
    }
}
