class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() >= 50000)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int longestLength = 0;

        int left = 0;
        for (int right = 0; right < s.length() - 1; right++) {
            char c = s.charAt(right);

            while(set.contains(c)){
                set.remove(c);
                int curLength = right - left;
                longestLength = Math.max(longestLength,curLength);
                left++;
            }
        set.add(c);
    }

    return longestLength;
    }
}
