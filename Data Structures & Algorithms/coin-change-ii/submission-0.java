class Solution {
    int min = 0;
    public int change(int amount, int[] coins) {
        if (coins.length == 0 || coins.length > 100)
            return 0;

        dfs(0, 0, amount, coins);
        return min;
    }

    public void dfs(int index, int sum, int amount, int[] coins) {
        if (sum > amount || index >= coins.length)
            return;

        if (sum == amount)
            min++;

        for (int i = index; i < coins.length; i++) {
            dfs(i, sum + coins[i], amount, coins);
        }
    }
}
