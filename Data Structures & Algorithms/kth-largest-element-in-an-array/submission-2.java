class Solution {
    public int findKthLargest(int[] nums, int k) {
        //set the base case(s).
        if(k == 0 || k > nums.length) return 0;

        if(nums.length == 0 || nums.length > 10000) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums){//O(n)
            pq.add(num); //O(logn)
        }

        int kNum = 0;
        
        while(!pq.isEmpty() && k > 0){//O(k log n)
            kNum = pq.poll();
            k--;
        }

        return kNum; 
        //time complexity -> O(n log n + k log n ) -> O(n log n)
        //space complexity -> O(n) additional space comes from prique at length of n.
    }
}
