class Solution {
    public String mergeAlternately(String word1, String word2) {
        //base case - invalid size.
        if(word1.isEmpty() || word1.length() > 100) return word2;
        if(word2.isEmpty() || word2.length() > 100) return word1; 

        //average case. 
        int i = 0; 
        int j = 0; 
        
        String result = "";
        while(i < word1.length() || j < word2.length()){
            
            if(i < word1.length()){
            result += word1.charAt(i);
            }

            if(j < word2.length()){
            result += word2.charAt(j);
            }
            i++;
            j++;
        }

        return result;
    }
}
