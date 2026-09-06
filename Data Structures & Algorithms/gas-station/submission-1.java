class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0) return 0;

        if(gas.length > 100000 || cost.length > 10000) return 0;

        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
        
        int total = 0;
        int res = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];

            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
