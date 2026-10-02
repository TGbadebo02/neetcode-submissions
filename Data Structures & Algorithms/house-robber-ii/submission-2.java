class Solution {
    public int rob(int[] nums) {
        int max1 = maxAmount(0, nums.length - 1, nums);
        int max2 = maxAmount(1, nums.length, nums);

        return Math.max(max1, max2);
    }

    public int maxAmount(int i, int end, int[] nums) {
        if (i >= end)
            return 0;

        int curHouse = nums[i] + maxAmount(i + 2, end, nums);

        int skipHouse = maxAmount(i + 1, end, nums);

        return Math.max(curHouse, skipHouse);
    }
}
