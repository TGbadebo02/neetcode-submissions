class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(0,new ArrayList<>(),target,0,nums);
        return result;
    }

    public void backTrack(int i, List<Integer> cmbntn,int target,int sum, int nums[]){
        if(sum > target){
            return;
        }
        if(target == sum){
            result.add(new ArrayList<>(cmbntn));
            return;
        }

        for(int index = i; index < nums.length; index++){
            cmbntn.add(nums[index]);
            backTrack(index, cmbntn,target,sum + nums[index],nums);
            cmbntn.remove(cmbntn.size() - 1);
        }

    }
}
