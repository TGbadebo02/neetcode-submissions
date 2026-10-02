class Solution {
    public int countSubstrings(String s) {
        int [] memo = new int[s.length()];
        Arrays.fill(memo,-1);

        dp(0, s, memo, 0);
        
        int maxCount = 0;

        for(int count : memo){
           maxCount += count;
        }

        return maxCount;
    }

    private int dp(int i, String s, int [] memo, int count) {
        if (i >= s.length())
            return 0;
        
        if(memo[i] != -1){
            return memo[i];
        }

        for (int index = i; index < s.length(); index++) {
            if (isPalindrome(s, i, index)) {
                count++;
            }
        }
        
        memo[i] = count;
        dp(i + 1, s, memo, 0);

        return memo[i];
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
