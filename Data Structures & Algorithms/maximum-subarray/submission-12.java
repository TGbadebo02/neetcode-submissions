class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxVal = Integer.MIN_VALUE;

        for(int num : nums){
            curSum += num;
            maxVal = Math.max(maxVal, curSum);

            if(curSum < 0){
                curSum = 0;
            }
        }

        return maxVal;
    }
}
