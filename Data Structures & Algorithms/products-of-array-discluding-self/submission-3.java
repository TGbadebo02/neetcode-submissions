class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1;
        result[0] = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            prefix *= nums[i];
            if (i + 1 <= nums.length - 1) {
                result[i + 1] = prefix;
            }
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix *= nums[i];
            if (i - 1 >= 0) {
                result[i - 1] *= suffix;
            }
        }
        return result;
    }
}
