class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0; 
        int minsteps = 0;

        //bcuz it can only go as far as end of the array.
        while(right < nums.length - 1){
            //track the furthest the move can go
            int furthest = 0;

            for(int i = left; i <= right; i++){
               furthest = Math.max(furthest,i + nums[i]);
            }
            left = right + 1;
            right = furthest;
            minsteps++;
        }
        return minsteps;
    }
}
