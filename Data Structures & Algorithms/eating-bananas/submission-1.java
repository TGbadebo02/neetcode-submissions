class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //BRUTE FORCE APPROACH.
        
        //base case.
        if(piles.length == 0) return 0;

        //Average case. 
        int maxPile = 0;
        int result = 0;
        for(int pile : piles){
            maxPile = Math.max(pile,maxPile);
        }
        result = maxPile;

        for(int k = 1; k <= maxPile; k++){
            int hoursCount = 0;

            for(int pile : piles){
                hoursCount += (int) Math.ceil((double) pile / k );
            }

            if(hoursCount <= h){
               result = Math.min(result,k);
            }
        }
        return result;
    }
}
