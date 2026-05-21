class Solution {
    public int lengthOfLongestSubstring(String s) {
        //set the base case.
        if(s.length() == 0 || s.length() > 1000) return 0;

        Set<Character> set = new HashSet<>();

        int maxLen = 0;
        int start = 0;
        //set.add(s.charAt(start));

        for(int i = 0; i < s.length(); i++){
            
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            int len = i - start + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
