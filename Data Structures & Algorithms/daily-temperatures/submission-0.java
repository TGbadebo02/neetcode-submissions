class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //set the base case.
        if(temperatures.length == 0 || temperatures.length > 1000) return new int[0];

        int [] resArray = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){
                int day = temperatures[i];
                int hotterDay = temperatures[j];
                
                if(hotterDay > day){
                    resArray[i] = j - i;
                    break;
                }
            }
        }

        return resArray;
    }
}
