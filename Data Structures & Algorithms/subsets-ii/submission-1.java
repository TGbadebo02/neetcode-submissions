class Solution {
    HashSet<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(0,new ArrayList<>(), nums);
        return new ArrayList<>(result);
    }

    public void backTrack(int i, List<Integer> list, int [] nums){

        if(i == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

            list.add(nums[index]);
            backTrack(index + 1, list, nums);
            list.remove(list.size() - 1);
            backTrack(index + 1, list, list);
    
    }
}
