class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // NAIVE APPROACH.
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        //[-1,0,1,2,-1,-4] n = 6
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        Collections.sort(list);

                        if(!set.contains(list)){
                            result.add(list);
                            set.add(list);
                        }
                    }
                }
            }
        }

        return result;
    }
}
