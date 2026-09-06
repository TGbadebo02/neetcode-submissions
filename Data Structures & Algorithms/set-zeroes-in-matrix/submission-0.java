class Solution {
    HashSet<String> set = new HashSet<>();
    public void setZeroes(int[][] matrix) {
         //set the base case.
         if(matrix.length == 0 || matrix.length > 200) return;
         if(matrix[0].length == 0 || matrix[0].length > 200) return; 
         
         //Average case.
         for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0) continue;

                else{
                    removeZeros(i,j,matrix);
                }
            }
         }
        
    }


    public void removeZeros(int i, int j, int[][]matrix){ 
        
        String cell = i + "," + j;
        //bounds and set check.
        if(i >= matrix.length || i < 0 || j >= matrix[i].length || j < 0 || set.contains(cell)) return;

        for(int index = 0; index < matrix[i].length; index++){
            matrix[i][index] = 0;
            set.add(i + "," + index);
        }

        for(int index = 0; index < matrix.length; index++){
            matrix[index][j] = 0;
            set.add(index + "," + j);
        }

        
    }
}
