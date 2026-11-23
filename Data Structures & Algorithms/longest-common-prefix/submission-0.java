class Solution {
    public String longestCommonPrefix(String[] strs) {
        // base case - invalid size.
        if (strs.length == 0 || strs.length > 200)
            return " ";

        // Average case.

        String source = strs[0];
        String prefix = " ";
        String longestPrefix = " ";
        for (int i = 1; i <= source.length(); i++) {
            prefix = source.substring(0, i);
            boolean common = true;

            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    common = false;
                    break;
                }
            }
                if (!common) {
                    break;
                } 
            longestPrefix = prefix;
        }
        return longestPrefix;
    }
}