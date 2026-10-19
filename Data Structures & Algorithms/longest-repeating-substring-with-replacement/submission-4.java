class Solution {
    public int characterReplacement(String s, int k) {
        // set the base case.
        if (s.length() == 0) {
            return 0;
        }
        // extract the containing values.
        HashSet<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int maxLen = 0;
        //AABBAAAA [A,B]
        for (char c : set) {//A
            char[] chars = s.toCharArray();
            int remaining = k;
            int left = 0;

            for (int right = 0; right < chars.length; right++) {
                if (chars[right] != c) {
                    remaining--;
                }

                while (remaining < 0) {
                    if (chars[left] != c) {
                        remaining++;
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
