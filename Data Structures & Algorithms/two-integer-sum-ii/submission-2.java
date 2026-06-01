class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //set the base case for invalid array size.
        if(numbers.length < 2 || numbers.length > 1000) return new int[0];

        int left = 0;
        int right = numbers.length - 1;

        while(left <= right){
            //case 1.
            if(numbers[left] + numbers[right] == target && left != right){
                return new int[]{left + 1, right + 1};
            }
            else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[0];
    }
}
