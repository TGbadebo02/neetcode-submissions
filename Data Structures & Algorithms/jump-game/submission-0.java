class Solution {
    public boolean canJump(int[] nums) {
        //set the base case.
        if(nums.length == 0 || nums.length > 1000) return false;

        int n = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= n ){
               n = i;
            }
        }
        return n == 0;
    }


}
