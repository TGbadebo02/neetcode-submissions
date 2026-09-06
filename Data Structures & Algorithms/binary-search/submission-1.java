class Solution {
    public int search(int[] nums, int target) {
        int targetIndex = -1;
        int left = 0;
        int right = nums.length;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                targetIndex = mid;
            }

           if (nums[mid] > target){
                right = mid - 1;
            }

            else{
               left = mid + 1;
            }
        }

        return targetIndex;
    }
}
