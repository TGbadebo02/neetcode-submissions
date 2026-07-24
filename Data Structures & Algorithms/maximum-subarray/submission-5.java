class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int subArraySum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            subArraySum = Math.max(nums[i], subArraySum + nums[i]);
            maxSum = Math.max(subArraySum, maxSum);
        }

        return maxSum;
    }
}
