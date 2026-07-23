class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        int row = dp.length - 1;
        int col = dp[0].length - 1;
        dp[row - 1][col - 1] = 1;

        for(int i = 0; i < col; i++){
            dp[row][i] = 0;
        }

        for(int i = 0; i < row; i++){
            dp[i][col] = 0;
        }

        for(int i = row - 1; i >= 0; i--){
            for(int j  = col - 1; j >= 0; j--){
                dp[i][j] = dp[i][j] + dp[i+1][j] + dp[i][j+1];
            }
        }
       
       return dp[0][0];
    }
}
