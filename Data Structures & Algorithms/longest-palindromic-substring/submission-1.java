class Solution {

    public String longestPalindrome(String s) {
        return findLongest(0, s, "");
    }

    private String findLongest(int i, String s, String lngstSubString) {
        if (i >= s.length())
            return lngstSubString;

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                if (s.substring(i, j + 1).length() >= lngstSubString.length()) {
                    lngstSubString = s.substring(i, j + 1);
                }
            }
        }

        return findLongest(i + 1, s, lngstSubString);
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
