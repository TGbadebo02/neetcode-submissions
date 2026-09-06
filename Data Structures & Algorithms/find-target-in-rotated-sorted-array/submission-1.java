class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            // this only basically check's one edge case.
            // even if its roated i need to still check which side it can be in.
            //this is sticlty checking left side even if roated or not.
            } else if (nums[mid] > target && nums[left] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
