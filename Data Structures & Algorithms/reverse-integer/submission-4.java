class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;

        boolean isNgtv = x < 0 ? true : false;
        long absoluteX = Math.abs((long)x);
        
        long newX = Long.parseLong(new StringBuilder(String.valueOf(absoluteX)).reverse().toString());

        if(isNgtv) newX *= -1;

        if(newX < -(1 << 31) || newX > (1 << 31) -1) return 0;

        return (int) newX;
    }

}
