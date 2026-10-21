class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // NAIVE APPROACH.

        if (nums.length == 0 || nums.length > 10000)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                maxVal = Math.max(maxVal, nums[j]);
            }
            list.add(maxVal);
            maxVal = Integer.MIN_VALUE;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
