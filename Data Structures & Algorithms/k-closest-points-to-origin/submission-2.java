class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // set the base case(s).
        if (points.length == 0 || points.length > 1000)
            return new int[0][0];
        if (k == 0 || k > 1000)
            return new int[0][0];


       PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
);

        for(int [] point : points){
            
            pq.offer(point);

            if(pq.size() > k){
                pq.poll();
            }
        } 


        int [][] resArray = new int[k][2];
        int i = 0;
        //"0,2" [0 , 2]
        while (!pq.isEmpty()) { //O(klogn)
            resArray[i++] = pq.poll();
        }

        // int [][] resArray = new int[result.size()][2];
        // for(int i = 0; i < result.size(); i++){ //O(k)
        //     for(int j = 0; j < 2; j++){
        //         resArray[i][j] = result.get(i).get(j);
        //     }
        // }
        
        return resArray;
    }
}
