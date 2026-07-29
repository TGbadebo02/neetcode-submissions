class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] pairs = new int [position.length][2];

        for(int i = 0; i < pairs.length; i++){
            int [] pair = pairs[i];
            pair[0] = position[i];
            pair[1] = speed[i];
        }
        
        Arrays.sort(pairs,(a,b) -> Integer.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < pairs.length; i++){
            
            double time = (double) (target - pairs[i][0]) / pairs[i][1]; 
            stack.add(time);

            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
