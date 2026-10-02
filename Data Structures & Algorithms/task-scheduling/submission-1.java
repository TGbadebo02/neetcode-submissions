class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new ArrayDeque<>();

        for (char c : tasks) {
            taskCount[c - 'A']++;
        }

        for (int num : taskCount) {
            if (num > 0)
                pq.add(num);
        }

        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            time++;
            // if the pq isn't empty, time is equal to last val in the queue.
            if (pq.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cur = pq.poll();
                // also important to ensure count isn't equal to 0/
                if (cur > 1) {
                    queue.add(new int[] {cur - 1, n + time});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] <= time) {
               pq.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
