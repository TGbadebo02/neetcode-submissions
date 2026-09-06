class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {

        int newN = sumHelper(n);
        
        if(set.contains(newN)) return false;
        
        if (newN != 1) {
            set.add(newN);
            int nChk = sumHelper(newN);
           isHappy(nChk);
        }

        //if(set.contains(newN)) return false;

        return true;
    }

    public int sumHelper(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            int digitTwo = (int) Math.pow(digit, 2);
            sum += digitTwo;
            n /= 10;
        }

        return sum;
    }
}
