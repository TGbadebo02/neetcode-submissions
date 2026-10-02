class Solution {
    private int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findWays(0, 0, nums, target, memo);
    }

    public int findWays(int i, int total, int[] nums, int target, int[][]memo) {
        if (i == nums.length) {
            if (total == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (memo[i][total + totalSum] != -1) return memo[i][total + totalSum];

        memo[i][total + totalSum] = findWays(i + 1, total + nums[i], nums, target, memo)
            + findWays(i + 1, total - nums[i], nums, target, memo);
        return memo[i][total + totalSum];
    }
}
