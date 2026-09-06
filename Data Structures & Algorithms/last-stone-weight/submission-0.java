class Solution {
    public int lastStoneWeight(int[] stones) {
        //base case. 
        if(stones.length == 0 || stones.length > 20) return 0;


        //Average case.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.add(stone);
        }
         // 
        while(pq.size() != 1){
            
            int x = pq.poll();
            int y = pq.poll();

            if(x == y) continue;

            int newWeight = x - y;

            pq.add(newWeight);
        }

        return pq.size() == 1 ? pq.peek() : 0;

    }
}
