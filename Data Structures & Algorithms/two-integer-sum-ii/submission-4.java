class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
          Brute-force approach.

           - iterate using a nested loop and then soon as two index equal target, return them.
          Optimized approach.
          - edge case(s).

          1) invalid size of array or target number, return empty array.

          2) Average case.
             - [1, 2] target = 3
                - if mid == 
        */

        if(numbers.length < 2 || numbers.length > 3000) return new int[0];

        if(target < -1000 || target > 1000) return new int[0];

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[0];
    }
}
