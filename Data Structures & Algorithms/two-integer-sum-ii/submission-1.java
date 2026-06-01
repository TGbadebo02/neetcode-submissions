class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //invalid array size index.
        if(numbers.length < 2 || numbers.length > 1000) return new int[0];

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target && i != j){
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }
}
