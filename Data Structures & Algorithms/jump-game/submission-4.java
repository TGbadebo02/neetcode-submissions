class Solution {
    public boolean canJump(int[] nums) {
        Boolean memo [] = new Boolean[nums.length];
        return recursiveHelper(0,nums,memo);
    }


    public boolean recursiveHelper(int i, int [] nums, Boolean [] memo){
        if(i >= nums.length - 1){
            return true;
        }
        
        if(memo[i] != null){
            return memo[i];
        }
        //int end = Math.min(nums.length - 1, i + nums[i]);

        for(int j = 1; j <= nums[i]; j++){
            if(recursiveHelper(j + i,nums,memo)){
                memo[i] = true;
                return memo[i];
            }
        }

        memo[i] = false;
        return memo[i];
    }
}
