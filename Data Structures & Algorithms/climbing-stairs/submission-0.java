class Solution {
    public int climbStairs(int n) {
        //base case.
        if(n == 1) return 1;
        if(n == 2) return 2;

        //average case
        int steps = climbStairs(n - 1) + climbStairs(n - 2);
        return steps;
    }
}
