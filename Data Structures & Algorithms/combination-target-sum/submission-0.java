class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        backTrack(0,new ArrayList<>(),nums,0,target);
        
        return result;
    }

    public void backTrack(int i, List<Integer> list, int [] nums, int sum, int target){
        
        if(target == sum) result.add(new ArrayList<>(list));

        if(i >= nums.length || sum > target) return;
        

        for(int index = i; index < nums.length; index++){
            list.add(nums[index]);
            backTrack(index, list, nums, sum + nums[index], target);
            list.remove(list.size() - 1);
        }
    }

}
