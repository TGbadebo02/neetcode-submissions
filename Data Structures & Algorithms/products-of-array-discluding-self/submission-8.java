class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*** edge case
        1.
        1st pass [48,24,12,8]
        2nd pass [12,8]
         **/

        if (nums.length == 0 || nums.length > 100000)
            return new int[0];

        int res[] = new int[nums.length];
        int prefix = 1;
        res[0] = prefix;
        // 1st pass.
        for (int i = 0; i < nums.length - 1; i++) {
            //get the prefix value from left side
            prefix *= nums[i];
            //update it at the index i + 1, everything from left excluding index 'i'
            res[i + 1] = prefix;
        }
        //2nd pass.
        int suffix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            //get the suffix value from right side
            suffix *= nums[i];
            //update it at the index exluding itself.
            res[i - 1] *= suffix;
        }

        return res;
    }
}
