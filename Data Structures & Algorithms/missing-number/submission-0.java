class Solution {
    public int missingNumber(int[] nums) {
        //handle invalid size.
        if(nums.length == 0 || nums.length > 1000) return 0;

        for(int i = 0; i <= nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
      return -1;
    }
}
