class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        java.util.Stack<int[]> stack = new java.util.Stack<>(); // {start index, height}

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] pair = stack.pop();
                int index = pair[0];
                int height = pair[1];

                maxArea = Math.max(maxArea, height * (i - index));
                start = index; // The shorter bar can extend this far left.
            }

            stack.push(new int[]{start, h});
        }

        // Remaining bars can extend to the end of the histogram.
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
