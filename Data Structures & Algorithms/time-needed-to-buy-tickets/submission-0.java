class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int seconds = 0;

        for(int i = 0; i < tickets.length; i++){
            queue.add(i);
        }

        //[2, 3, 2].

        while(!queue.isEmpty()){
            seconds++;

            int person = queue.poll();
            tickets[person]--;
            
            if(tickets[person] == 0){
                if(person == k){
                    return seconds;
                }
            }else{
                queue.add(person);
            }
            
        }

        return seconds;
    }
}