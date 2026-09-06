class Solution {
    public void rotate(int[][] matrix) {
        // base case.
        if (matrix.length == 0 || matrix.length > 1000)
            return;

        // Average case.
        int n = matrix.length;

        int[] row1 = new int[n];

        for (int i = 0; i < row1.length; i++) {
            row1[i] = matrix[0][i];
        }

        int[] col1 = new int[n];

        for (int i = 0; i < col1.length; i++) {
            col1[i] = matrix[i][0];
        }

        int[] row2 = new int[n];

        for (int i = 0; i < row2.length; i++) {
            row2[i] = matrix[n - 1][i];
        }

        int[] col2 = new int[n];

        for (int i = 0; i < col2.length; i++) {
            col2[i] = matrix[i][n - 1];
        }

        /*THIS MISTAKE IS IM NOT COPYING THEM OVER IN ORDER.*/
        // for(int i = 0; i < n; i++){
        //     matrix[0][i] = col1[i];
        //     matrix[i][0] = row2[i];
        //     matrix[n-1][i] = row1[i];
        //     matrix[i][n-1] = col2[i];
        // }

        for (int i = 0; i < n; i++) {
            matrix[i][n - 1] = row1[i]; // top -> right
            matrix[n - 1][i] = col2[n - 1 - i]; // right -> bottom
            matrix[i][0] = row2[i]; // bottom -> left
            matrix[0][i] = col1[n - 1 - i]; // left -> top
        }
    }
}
