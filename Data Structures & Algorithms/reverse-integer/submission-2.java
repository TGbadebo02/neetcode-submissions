class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;;

        boolean isNgtv = x < 0 ? true : false;
        x = Math.abs(x);
        
        long newX = Long.parseLong(new StringBuilder(String.valueOf(x)).reverse().toString());

        if(isNgtv) newX *= -1;

        if(newX < -(1 << 31) || newX > (1 << 31) -1) return 0;

        return (int) newX;
    }

}
