class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int col = matrix[0].length;

        int topRow = 0;
        int bottomRow = rows - 1;

        while(topRow <= bottomRow){
            int row = (topRow + bottomRow) / 2;
            if(target > matrix[row][matrix[row].length - 1]){
                topRow = row + 1;
            }else if(target < matrix[row][0]){
                bottomRow = row - 1;
            }else{
                break;
            }
        }

        if(topRow > bottomRow){
            return false;
        }
        
        int row = (topRow + bottomRow) / 2;
        int left = 0;
        int right = col - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;

            if(target > matrix[row][mid]){
                left = mid + 1;
            }

            else if(target < matrix[row][mid]){
                right = mid - 1;
            }

            else{
                return true;
            }
        }

        return false;
    }
}
