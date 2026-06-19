class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(pile,maxPile);
        }

        int left = 1, right = maxPile;
        int result = right;

        while(left <= right){
            int hoursCount = 0;
            int k = (left + right) / 2;

            for(int pile : piles){
                hoursCount+= (int) Math.ceil((double)pile/k);
            }

            if(hoursCount <= h){
                result = Math.min(result,k);
                right = k - 1;
            }else{
                left = k + 1;
            }
        }
        return result;
    }
}
