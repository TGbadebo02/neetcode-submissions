class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) return false;

    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s1.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int left = 0;
    int needed = s1.length();

    for (int right = 0; right < s2.length(); right++) {
        char rightChar = s2.charAt(right);

        if (map.containsKey(rightChar)) {
            if (map.get(rightChar) > 0) {
                needed--;
            }
            map.put(rightChar, map.get(rightChar) - 1);
        }

        if (right - left + 1 > s1.length()) {
            char leftChar = s2.charAt(left);

            if (map.containsKey(leftChar)) {
                if (map.get(leftChar) >= 0) {
                    needed++;
                }
                map.put(leftChar, map.get(leftChar) + 1);
            }

            left++;
        }

        if (needed == 0) {
            return true;
        }
    }

    return false;
    }
}
