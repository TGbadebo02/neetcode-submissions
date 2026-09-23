class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        
        int memo1[] = new int[nums.length];
        int memo2[] = new int[nums.length];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        int max1 = maxAmount(0, nums.length - 1, nums, memo1);
        int max2 = maxAmount(1, nums.length, nums, memo2);

        return Math.max(max1, max2);
    }

    public int maxAmount(int i, int end, int[] nums, int memo[]) {
        if (i >= end)
            return 0;

        if (memo[i] != -1) {
            return memo[i];
        }

        int curHouse = nums[i] + maxAmount(i + 2, end, nums, memo);

        int skipHouse = maxAmount(i + 1, end, nums, memo);

        memo[i] = Math.max(curHouse, skipHouse);
        return memo[i];
    }
}
