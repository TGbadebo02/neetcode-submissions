class Solution {
    public int numDecodings(String s) {
        if(s.length() == 1 && s.charAt(0) == '0') return 0;

        String word = " ";
        word += s.charAt(0);

        return findWays(0,s);
    }

    public int findWays(int index, String s){
        if(index >= s.length() - 1){
            return 1;
        }

        int val1 = s.charAt(index) - '0';

        if(val1 < 1){
            return 0;
        }

        int val2 = s.charAt(index + 1) - '0';

        if((val1 == 1 && val2 == 0) || (val1 == 2 && val2 > 6) || (val1 > 2)){
            return findWays(index + 2, s);
        }

        return findWays(index + 1, s) + findWays(index + 2, s);


    }
}
