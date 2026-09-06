class Solution {
    public int maxSubArray(int[] nums) {
        //set base case.
        if(nums.length == 0 || nums.length > 1000) return 0;

        if(nums.length == 1) return nums[0];

        int sum = 0;
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }
}
