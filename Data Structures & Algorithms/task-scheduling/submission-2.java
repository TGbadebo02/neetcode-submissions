class Solution {
    public int leastInterval(char[] tasks, int n) {
        /**
        Edge case 1 :
          X -> Y ->  _ -> X -> Y
          time 1 use another x takes.. 3

       Edge case 2 :
         A -> B -> C -> idle -> A -> B -> idle -> idle - > idle -> A.
         time 1, queue [(2,4) + (0,5), ]
          case handling :
           if the pq is empty and queue is not, return the time of the last task to proces..
           if the queue is empty and pq is not.. add it back to the queue.
        */

        int[] charCount = new int[26];

        for (char c : tasks) {
            charCount[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int count : charCount) {
            if (count > 0) {
                pq.add(count);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        /*
        Edge case 1 -> X : 2, Y : 2
        queue - [(1,5)]
        time : 3
        */
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            // int task = pq.poll();

            if (pq.isEmpty()) {
                time = queue.peek()[1];
            }

            else {
                int task = pq.poll();
                if (task > 1) {
                    queue.add(new int[] {task - 1, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
