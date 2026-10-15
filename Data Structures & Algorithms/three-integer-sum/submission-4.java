class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Optimized Approach.
            - sort the array.. O(nlogn) e.g [-4,-1,-1,0,1,2]
            - iterate through the array and then run a 2-pntr technique right side.
               - if sum < target, increment left
               - if sum > target, dcrmnt right
               - if equal sort an
        */

        List<List<Integer>> result = new ArrayList<>();
        int startIndex = Integer.MIN_VALUE;
        //-4 -1 -1 0 1 2
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (nums[i] == startIndex) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    startIndex = nums[i];
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            startIndex = nums[i];
        }
        return result;
    }
}
