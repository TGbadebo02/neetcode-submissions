class Solution {
    public String minWindow(String s, String t) {
        // base case.
        if (s.equals(t)) {
            return t;
        }

        if (t.length() > s.length())
            return "";

        int minLen = Integer.MAX_VALUE;
        int[] indxArray = {-1, -1};

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                map2.put(c, map2.getOrDefault(c, 0) + 1);

                boolean flag = true;
                for (char c2 : map.keySet()) {
                    if (map2.getOrDefault(c2, 0) < map.get(c2)) {
                        flag = false;
                        break;
                    }
                }

                if (flag && (j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    indxArray[0] = i;
                    indxArray[1] = j;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(indxArray[0], indxArray[1] + 1);
    }
}
