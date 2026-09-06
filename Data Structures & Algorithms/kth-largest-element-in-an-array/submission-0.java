class Solution {
    public int findKthLargest(int[] nums, int k) {
        //set the base case(s).
        if(k == 0 || k > nums.length) return 0;

        if(nums.length == 0 || nums.length > 1000) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums){
            pq.add(num);
        }

        int kNum = 0;
        
        while(!pq.isEmpty() && k > 0){
            kNum = pq.poll();
            k--;
        }

        return kNum;
    }
}
