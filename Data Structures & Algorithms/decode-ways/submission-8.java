class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) == '0')
            return 0;

        String word = " ";
        word += s.charAt(0);

        return findWays(0, s);
    }

    public int findWays(int index, String s) {
        if (index >= s.length()) {
            return 1;
        }

        int val1 = s.charAt(index) - '0';

        if (val1 < 1) {
            return 0;
        }
    

        if (index + 1 >= s.length()) {
          return findWays(index + 1, s);
        }

        int val2 = s.charAt(index + 1) - '0';

        if ((val1 == 2 && val2 > 6) || (val1 > 2)) {
            return findWays(index + 1, s);
        }

        if(val2 == 0){
            return findWays(index + 2, s);
        }

        return findWays(index + 1, s) + findWays(index + 2, s);
    }
}
