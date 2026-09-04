class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // set the base case.
        if (matrix.length == 0 || matrix.length > 10)
            return new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right) {
            // top-left -> top-right.
            for (int i = left; i <= right; i++) {
                String cell = top + "," + i;

                if (!set.contains(cell)) {
                    set.add(cell);
                    result.add(matrix[top][i]);
                }
            }

            // top-right -> bottom-right.
            for (int i = top; i <= bottom; i++) {
                String cell = i + "," + right;

                if (!set.contains(cell)) {
                    set.add(cell);
                    result.add(matrix[i][right]);
                }
            }

            // right-bottom -> left-bottom.
            for (int i = right; i >= left; i--) {
                String cell = bottom + "," + i;

                if (!set.contains(cell)) {
                    set.add(cell);
                    result.add(matrix[bottom][i]);
                }
            }

            // left-bottoom -> top -lef;

            for (int i = bottom; i >= top; i--) {
                String cell = i + "," + left;

                if (!set.contains(cell)) {
                    set.add(cell);
                    result.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
