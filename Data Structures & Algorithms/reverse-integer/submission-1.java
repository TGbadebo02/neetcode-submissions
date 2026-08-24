class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;

        String number = "";

        boolean isNgtv = x < 0 ? true : false;

        while(x != 0){
            int digit = x % 10;
            number += Integer.toString(Math.abs(digit));
            x /= 10;
        }

        long newX = Long.parseLong(number);

        if(isNgtv) newX *= -1;

        if(newX < Integer.MIN_VALUE || newX > Integer.MAX_VALUE) return 0;

        return (int) newX;
    }

}
