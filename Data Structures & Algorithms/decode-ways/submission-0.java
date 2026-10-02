class Solution {
    public int numDecodings(String s) {
        String word = " ";
        word += s.charAt(0);

        return findWays(0,s);
    }

    public int findWays(int index, String s){
        if(index >= s.length()-1){
            return 1;
        }

        int val1 = s.charAt(index) - '0';

        if(val1 < 1){
            return 0;
        }

        if(val1 > 2 && val1 < 10){
            return findWays(index + 1, s);
        }

        return findWays(index + 1, s) + findWays(index + 2, s);


    }
}
