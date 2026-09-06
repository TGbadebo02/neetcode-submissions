class Solution {
    int min = 0;
    public int change(int amount, int[] coins) {
        if (coins.length == 0 || coins.length > 1000)
            return 0;
        
        //Integer [] memo = new Integer[coins.length];
        dfs(0, 0, amount, coins);
        return min;
    }

    public void dfs(int index, int sum, int amount, int[] coins) {
        if (sum > amount || index >= coins.length)
            return;
        
        //if(memo[index] != null) return memo[index];

        if (sum == amount)
           min++;
        
        for (int i = index; i < coins.length; i++) {
            dfs(i, sum + coins[i], amount, coins);
        }

        //return memo[index] = min;
    }
}
