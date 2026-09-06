class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0) return 0;

        if(gas.length > 100000 || cost.length > 10000) return 0;

        int n = gas.length;
        int [] diff = new int[n];

        int gasSum = 0;
        int costSum = 0;

        for(int i = 0; i < n; i++){
            gasSum += gas[i];
            costSum += cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if(gasSum < costSum) return -1;
        
        int startIndex = Integer.MAX_VALUE;

        for(int i = 0; i < diff.length; i++){
           if(diff[i] > 0){
             startIndex = Math.min(startIndex, i);
           }
        }

        return startIndex;
    }
}
