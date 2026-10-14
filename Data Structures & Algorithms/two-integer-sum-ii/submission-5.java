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
             - [1, 2, 3, 4] target = 3.
             - [2, 3, 5, 7] target = 8.
                - if nums[left] + nums[right] == target, return left, right.
                - if nums[left] + nums[right] > target, reduce right.
                - if nums[right] + nums[left] < target, increase righ
        */

        int left = 0;
        int right = numbers.length - 1;

        while(left <= right){
            //int mid = (left + right) / 2; 

            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            }

            else if(numbers[left] + numbers[right] > target){
                right--;
            }

            else{
                left++;
            }
        }

        return new int[0];
    }
}
