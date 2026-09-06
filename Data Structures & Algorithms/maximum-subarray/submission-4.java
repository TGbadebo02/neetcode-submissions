class Solution {
    public int maxSubArray(int[] nums) {
        //set the base case.
        if(nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int subArraySum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int sum : nums){
            subArraySum += sum;
        }

        for(int i = 0; i < nums.length -1 ; i++){
            subArraySum -= nums[i];
            maxSum = Math.max(subArraySum,maxSum);
        }

        return maxSum;
    }
}
