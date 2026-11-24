class Solution {
    public boolean validPalindrome(String s) {
        // base case - invalid size.
        if (s.length() == 0 || s.length() > 100000)
            return false;

        if (isPalindrome(0, s.length() - 1, s))
            return true;
        
        boolean isPalindrome = false; 
        for (int i = 1; i < s.length(); i++) {
            String str1 = s.substring(0, i);
            String str2 = s.substring(i + 1);

                               String res = str1 + str2;

            if (isPalindrome(0, res.length() - 1, res))
                isPalindrome = true;
        }

        return isPalindrome;
    }

    public boolean isPalindrome(int left, int right, String word) {
        if (left > right)
            return false;

        if (word.isEmpty())
            return false;

        left = 0;
        right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}