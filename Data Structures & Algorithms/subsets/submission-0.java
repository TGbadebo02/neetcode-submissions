class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();

        backTrack(0, subset, nums);

        return result;
    }


    public void backTrack(int i, List<Integer> subset, int [] nums){
        //base case.
        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[i]);
        backTrack(i + 1, subset, nums);
        subset.remove(subset.size()-1);
        backTrack(i + 1, subset, nums);
    }
}
