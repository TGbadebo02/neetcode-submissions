class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) { 
       // better base case -> check if its divisible by groupSize.
       if(hand.length % groupSize != 0) return false;
       // if(hand.length == 0 || hand.length > 1000) return false; 

        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : hand){
           map.put(num,map.getOrDefault(num,0) + 1);
        }
       
        Arrays.sort(hand);
    
        List<Integer> group = new ArrayList<>();

        for(int num : hand){
            if(map.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    if(map.getOrDefault(i,0) == 0) return false;
                    map.put(i,map.get(i) - 1);
                }
            }
        }

        return true;
    }
}
