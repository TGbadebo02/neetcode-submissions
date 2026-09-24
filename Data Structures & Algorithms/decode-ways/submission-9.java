class Solution {
    public int numDecodings(String s) {
        int memo [] = new int [s.length()];
        Arrays.fill(memo, -1);

        if (s.length() == 1 && s.charAt(0) == '0')
            return 0;

        String word = " ";
        word += s.charAt(0);

        return findWays(0, s, memo);
    }

    public int findWays(int index, String s, int [] memo) {
        if (index >= s.length()) {
            return 1;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        int val1 = s.charAt(index) - '0';

        if (val1 < 1) {
            return 0;
        }
    

        if (index + 1 >= s.length()) {
          memo[index] = findWays(index + 1, s, memo);
          return memo[index];
        }

        int val2 = s.charAt(index + 1) - '0';

        if ((val1 == 2 && val2 > 6) || (val1 > 2)) {
            memo[index] = findWays(index + 1, s,memo);
            return memo[index];
        }

        if(val2 == 0){
            memo[index] = findWays(index + 2, s, memo);
            return memo[index];
        }

        memo[index] = findWays(index + 1, s, memo) + findWays(index + 2, s, memo);
        return memo[index];
    }
}
