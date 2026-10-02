class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        recursiveHelper(0, s);
        return count;
    }

    private void recursiveHelper(int i, String s) {
        if (i >= s.length())
            return;

        for (int index = i; index < s.length(); index++) {
            if (isPalindrome(s, i, index)) {
                count++;
            }
        }

        recursiveHelper(i + 1, s);
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
