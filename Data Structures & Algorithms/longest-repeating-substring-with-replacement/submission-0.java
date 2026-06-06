class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();        
        // for(int i = 0; i < s.length(); i++){

        //     for(int j = 0; j < s.length(); j++){
        //         //add each chrctr and frequency to d map.
        //         char c = s.charAt(j);
        //         map.put(c,map.getOrDefault(c,0) + 1);



        //     }
        // }

        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(c));

            while((right - left + 1) - maxFreq  > k){
                  char leftChar = s.charAt(left);
                  map.put(leftChar, map.get(leftChar) - 1);

                  if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                  }
                  left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }
}
