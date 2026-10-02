class Solution {
    public int rob(int[] nums) {
        return findMaxMoney(0, nums, 0);
    }

    public int findMaxMoney(int i, int [] nums, int total){
        if(i >= nums.length) return 0;

        int curHouse = nums[i] + findMaxMoney(i + 2, nums, total);

        int skipHouse = findMaxMoney(i + 1, nums, total);

        return Math.max(curHouse,skipHouse);
    }
}
