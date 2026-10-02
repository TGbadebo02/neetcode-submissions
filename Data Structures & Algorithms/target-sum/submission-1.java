class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findWays(0, nums, 0, target);
    }

    public int findWays(int i, int [] nums, int total, int target){
        if(i == nums.length){
            if(total == target) return 1;

            else{
                return 0;
            }
        }
        //THEN IM ADDING PREVIOUS VALUES
        return findWays(i + 1, nums, total - nums[i], target) + findWays(i + 1, nums, total + nums[i],target); 
    }


}
