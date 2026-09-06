class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         
        //base case.
        if(text1.isEmpty() || text2.isEmpty()) return 0;

        int row = text1.length();
        int col = text2.length();

        int [][] dp = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1;
                }
            }
        }

        int sLen = 0;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                sLen += dp[i][j];
            }
        }

        return sLen;
    }
}
