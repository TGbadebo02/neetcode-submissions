class Solution {
    public int maxSubArray(int[] nums) {
        
        //base case.
        if(nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        //average case.

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int subArraysum = 0;
            for(int j = i ; j < nums.length; j++){
                subArraysum += nums[j];
                maxSum = Math.max(maxSum, subArraysum);
            }
        }

        return maxSum;
    }
}
