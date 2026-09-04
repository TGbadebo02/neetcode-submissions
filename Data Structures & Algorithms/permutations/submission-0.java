class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(0,nums,new ArrayList<>(), new HashSet<>());
        return result;
    }

    public void dfs(int i, int [] nums, List<Integer> list,HashSet<Integer> set){
        
        if(list.size() == nums.length){
        result.add(new ArrayList<>(list));
        return;
        }

        for(int index = 0; index < nums.length; index++){
            if(!set.contains(nums[index])){
            list.add(nums[index]);
            set.add(nums[index]);
            dfs(index,nums,list,set);
            list.remove(list.size() - 1);
            set.remove(nums[index]);
        }
    }
    }
}
