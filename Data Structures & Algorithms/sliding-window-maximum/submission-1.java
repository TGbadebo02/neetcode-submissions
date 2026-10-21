class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // NAIVE APPROACH.

        if (nums.length == 0 || nums.length > 10000)
            return new int[0];

        int res [] = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //[0 1 1 2 2 4 6]
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxVal = nums[i];
            for (int j = i; j < i + k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            res[i] = maxVal;
        }
        return res;
    }
}
