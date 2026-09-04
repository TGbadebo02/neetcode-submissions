class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() > 0) pq.offer(entry.getValue());
        }

        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        while(!queue.isEmpty()|| !pq.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = queue.peek()[1];
            }
            else{
                int count = pq.poll() - 1;
                if(count != 0){
                    queue.offer(new int[]{count, n + time});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                pq.offer(queue.poll()[0]);
            }

        }
        return time;
    }
}
