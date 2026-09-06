class Solution {
    public int trap(int[] height) {
        // set the base case for invalid array size.
        if (height.length == 0 || height.length > 1000) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left <= right) {
            int hght = Math.min(height[left], height[right]);
            int curArea = hght * (right - left - 1);
            maxArea = Math.max(maxArea, curArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
