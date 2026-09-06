class Solution {
    int minCost = 0;
    public int minCostClimbingStairs(int[] cost) {

        int frstStp = recursiveHelper(0,cost);
        int sndStp = recursiveHelper(1,cost);

        return Math.min(frstStp,sndStp);
    }

    public int recursiveHelper(int i, int [] cost){
        //base case.
        if(i >= cost.length){
            return 0;
        }

        int step1 = cost[i] + recursiveHelper(i + 1, cost);
        int step2 = cost[i] + recursiveHelper(i + 2, cost);

        return Math.min(step1, step2);

    }
}
