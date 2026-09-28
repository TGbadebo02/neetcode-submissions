class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int longestStart = 0;
        int longestLength = 1;

        for(int i = n - 1; i >= 0; i--){
            dp[i][i] = true;
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (s.substring(i,j).length() == 1 || dp[i+1][j-1])){
                    dp[i][j] = true;

                    int currentLength = j - i + 1;

                    if(currentLength > longestLength){
                        longestStart = i;
                        longestLength = currentLength;
                    }
                }
            }
        }
        return s.substring(longestStart,longestStart + longestLength);
    }
}
