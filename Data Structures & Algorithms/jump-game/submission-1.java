class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;

        int n = nums.length;
        int goal = n - 1;

        for(int i = n - 2;i >= 0; i--){
            if(goal - i == nums[i]){
                goal = i;
            }
        }

        return goal == 0;
    }
}
