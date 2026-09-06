class Solution {
    public String minWindow(String s, String t) {
        // base case.
        if (s.isEmpty() || t.isEmpty())
            return "";

        Map<Character, Integer> wantMap = new HashMap<>();
        int want = t.length();
        int need = 0;

        int minLen = Integer.MAX_VALUE;
        int[] subArrIndex = new int[2];

        for (char c : t.toCharArray()) {
            wantMap.put(c, wantMap.getOrDefault(c, 0) + 1);
        }

        for (int left = 0; left < s.length(); left++) {
            HashMap<Character, Integer> needMap = new HashMap<>();
            for (int right = left; right < s.length(); right++) {
                char c = s.charAt(right);
                if (wantMap.containsKey(c) && wantMap.get(c) != 0) {
                    need++;
                    needMap.put(c, needMap.getOrDefault(c, 0) + 1);
                    int num = needMap.get(c) - 1;
                    needMap.remove(c);
                    needMap.put(c,num);
                } 
                
                if(right - left < minLen && need == want){
                    subArrIndex = new int[]{left, right + 1};
                }
            }
        }

        return s.substring(subArrIndex[0],subArrIndex[1]);
    }
}
