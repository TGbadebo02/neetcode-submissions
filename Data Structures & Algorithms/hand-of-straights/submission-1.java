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
         //the error was that my algorithm wasnt breaking them up into groups basically
         // so in the case when it should be true it returned false;
            if(group.size() == groupSize){
                group.clear();
            }else{
                group.add(num);
                int count = map.get(num);
                count--;
                map.remove(num);
                map.put(num,count);
            }

        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > 0) return false;
        }

        return true;
    }
}
