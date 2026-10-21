class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // Store the value and its index.
            pq.offer(new int[]{nums[i], i});

            if (i >= k - 1) {
                // Remove expired entries when they reach the top.
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                res[idx++] = pq.peek()[0];
            }
        }
        return res;
    }
}
