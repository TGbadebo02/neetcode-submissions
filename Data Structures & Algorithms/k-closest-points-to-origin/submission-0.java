class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // set the base case(s).
        if (points.length == 0 || points.length > 1000)
            return new int[0][0];
        if (k == 0 || k > 1000)
            return new int[0][0];

        HashMap<String, Double> map = new HashMap<>();

        for (int[] point : points) { // o(n)
            String pntStr = Integer.toString(point[0]) + "," + Integer.toString(point[1]);
            double value = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            map.put(pntStr, value);
        }

        PriorityQueue<Map.Entry<String, Double>> pq =
            new PriorityQueue<>((a, b) -> Double.compare(a.getValue(), b.getValue())); // o(nlogn)

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            pq.add(entry); // o(logn)
        }

        List<List<Integer>> result = new ArrayList<>();
        //"0,2" [0 , 2]
        while (!pq.isEmpty() && k != 0) {
            Map.Entry<String, Double> entry = pq.poll();
            String [] parts = entry.getKey().split(",");
            int digit1 = Integer.parseInt(parts[0]);
            int digit2 = Integer.parseInt(parts[1]);
            List<Integer> list = new ArrayList<>();
            list.add(digit1);
            list.add(digit2);
            result.add(list);
            k--;
        }

        int [][] resArray = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < 2; j++){
                resArray[i][j] = result.get(i).get(j);
            }
        }

        return resArray;
    }
}
