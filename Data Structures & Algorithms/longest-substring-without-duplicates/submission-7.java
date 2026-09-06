class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longestLength = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int curLength = right - left;
            
            while(set.contains(c)){
                set.remove(s.charAt(left));
               // int curLength = right - left;
                longestLength = Math.max(longestLength,curLength);
                left++;
            }
        set.add(c);
        longestLength = Math.max(longestLength,right - left);
    }

    return longestLength;
    }
}
