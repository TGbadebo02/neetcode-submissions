class Solution {
    //int min = 0;
    public int change(int amount, int[] coins) {
        if (coins.length == 0)
            return 0;
        
        Integer [][] memo = new Integer[coins.length][amount + 1];
        return dfs(0, 0, amount, coins,memo);
        //return min;
    }

    public int dfs(int index, int sum, int amount, int[] coins,Integer [][] memo) { if(sum == amount) return 1;
    
        if (sum > amount || index >= coins.length)
            return 0;
        
        if(memo[index][sum] != null) return memo[index][sum];

        int moves = 0;
        
        for (int i = index; i < coins.length; i++) {
            moves += dfs(i, sum + coins[i], amount, coins,memo);
        }

        return memo[index][sum] = moves;
    }
}
