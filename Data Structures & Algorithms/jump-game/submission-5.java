class Solution {
    public boolean canJump(int[] nums) {
        /*
          edge case :
        [2, 0, 1, 2, 0]... just 1 at index 3 instead of 2/
          
        [0, 1, 2, 0].. fail from the jump.
        [1, 2, 0, 0, 1].. fail becaus

        */
        
        int n = nums.length;
        int goal = n - 1;

        for(int i = n - 2; i >= 0; i--){
            if(goal - i <= nums[i]){
                goal = i;
            }
        }
        return goal == 0 ? true : false;
    }
}
