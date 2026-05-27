class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Average case
        for(int i = 0; i < matrix.length; i++){
            if(binarySearch(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int [] array, int target){
         int left = 0;
         int right = array.length - 1;

         while(left <= right){
            int mid = (left + right) / 2;

            if(array[mid] == target){
                return true;
            }

            if(array[mid] > target){
                right = mid - 1;
            }

            if(array[mid] < target){
                left = mid + 1;
            }
         }

         return false;
    }

}
