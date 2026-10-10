class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> grids = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                if(board[row][col] == '.') continue;

                int subRow = Math.round(row / 3);
                int subCol = Math.round(col / 3);

                String r = row + "," + board[row][col];
                String c = col + "," + board[row][col];
                String grid = "{"+ subRow + "," +subCol + "}" + "," + board[row][col];

                if (rows.contains(r) || cols.contains(c)
                    || grids.contains(grid)) {
                    return false;
                } else {
                    rows.add(r);
                    cols.add(c);
                    grids.add(grid);
                }
            }
        }

        return true;
    }
}
