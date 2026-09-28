class Solution {

    public String longestPalindrome(String s) {
        String memo [] = new String[s.length()];

        return findLongest(0, s, "",memo);
    }

    private String findLongest(int i, String s, String lngstSubString, String [] memo) {
        if (i >= s.length())
            return lngstSubString;

        if(memo[i] != null) return memo[i];

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                if (s.substring(i, j + 1).length() >= lngstSubString.length()) {
                    lngstSubString = s.substring(i, j + 1);
                }
            }
        }

        memo[i] = findLongest(i + 1, s, lngstSubString, memo);
        return memo[i];
    }

    private boolean isPalindrome(int left, int right, String s) {
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
