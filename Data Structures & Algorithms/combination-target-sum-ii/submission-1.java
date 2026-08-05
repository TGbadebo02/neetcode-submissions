class Solution {
    HashSet<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0, candidates, new ArrayList<>(), 0, target);
        return new ArrayList<>(result);
    }

    public void backTrack(int i, int[] array, List<Integer> list, int sum, int target) {
        // base case(s).
        if (sum == target)
            result.add(new ArrayList<>(list));

        if (sum > target || i >= array.length) {
            return;
        }

        for (int index = i; index < array.length; index++) {
            if(index > i && array[index] == array[index - 1]) continue;
            
            list.add(array[index]);
            backTrack(index + 1, array, list, sum + array[index], target);
            list.remove(list.size() - 1);
            //set.remove(index);
        }
    }
}
