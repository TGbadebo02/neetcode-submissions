class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        
        int [][] memo = new int[row + 1][col + 1];


        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                }else{
                    memo[i][j] = Math.max(memo[i+1][j],memo[i][j+1]);
                }
            }
        }
        
        return memo[0][0];
    }
}
