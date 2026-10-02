class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int min1 = recursiveHelper(0, cost, 0);
        int min2 = recursiveHelper(1, cost, 0);

        return Math.min(min1, min2);
    }

    public int recursiveHelper(int i, int [] cost, int total){
        if(i >= cost.length){
            return total;
        }

        int floor1 = recursiveHelper(i + 1, cost, total + cost[i]);
        int floor2 = recursiveHelper(i + 2, cost, total + cost[i]);

        return Math.min(floor1, floor2);
    }
}
