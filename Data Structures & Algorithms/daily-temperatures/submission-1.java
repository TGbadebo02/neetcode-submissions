class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //set the base case.
        if(temperatures.length == 0 || temperatures.length > 1000) return new int[0];

        int [] resArray = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
           while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index =  stack.pop();
                resArray[index] = i - index;
           }
           stack.add(i);
        }

        return resArray;
    }
}
