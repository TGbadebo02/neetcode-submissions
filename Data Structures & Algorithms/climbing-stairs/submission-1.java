class Solution {
    public int climbStairs(int n) {
        Integer [] memo = new Integer[n + 1];
        //base case.
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] != null){
            return memo[n];
        }
        //average case
        memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return memo[n];
    }
}
