class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0 || m > 200 || n == 0 || n > 200) return;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) { // o(mn) -> row x col.
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                } else {
                    continue;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] == true || col[j] == true){
                    matrix[i][j] = 0;
                }else{
                    continue;
                }
            }
        }
    }
}
