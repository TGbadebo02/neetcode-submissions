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
            prefix *= nums[i];
            res[i + 1] = prefix;
        }
        int suffix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            suffix *= nums[i];
            res[i - 1] *= suffix;
        }

        return res;
    }
}
