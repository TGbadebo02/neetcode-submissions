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

        Map<Character, Integer> wantMap = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int ndMptl = needMap.size();
        int wntMptl = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            wantMap.put(c, wantMap.getOrDefault(c, 0) + 1);

            if (needMap.containsKey(c) && wantMap.get(c).equals(needMap.get(c))) {
                wntMptl++;
            }

            while (wntMptl == ndMptl) {
                if ((right - left + 1) < minLen) {
                    indxArray[0] = left;
                    indxArray[1] = right;
                    minLen = (right - left + 1);
                }
                char lftChr = s.charAt(left);
                wantMap.put(lftChr, wantMap.get(lftChr) - 1);

                if (needMap.containsKey(s.charAt(left))
                    && wantMap.get(s.charAt(left)) < needMap.get(lftChr)) {
                    wntMptl--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(indxArray[0], indxArray[1] + 1);
    }
}