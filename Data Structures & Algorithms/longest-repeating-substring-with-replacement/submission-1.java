class Solution {
    public int characterReplacement(String s, int k) {
        // set the base case.
        if (s.length() == 0 || s.length() > 10000) {
            return 0;
        }
        // extract the containing values.
        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        //{X, Y}
        int maxLen = 0;

        for (char c : set) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c)
                    continue;

                if (chars[i] != c && k != 0) {
                    chars[i] = c;
                    k--;
                }
            }

            String word = new String(chars);
            // XXXX

            int left = 0;
            for (int right = 0; right < word.length(); right++) {
                while(word.charAt(left) != word.charAt(right)) {
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
