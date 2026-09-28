class Solution {
    Set<Integer> cellSet = new HashSet<>();
    Set<Integer> pstvDiagonal = new HashSet<>();
    Set<Integer> ngtvDiagonal = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] array = new char[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '.';
            }
        }
        backTrack(0, n, array);
        return result;
    }

    private void backTrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            result.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cellSet.contains(c) || pstvDiagonal.contains(r + c)
                || ngtvDiagonal.contains(r - c)) {
                continue;
            }

            cellSet.add(c);
            pstvDiagonal.add(r + c);
            ngtvDiagonal.add(r - c);
            board[r][c] = 'Q';

            backTrack(r + 1, n, board);

            cellSet.remove(c);
            pstvDiagonal.remove(r + c);
            ngtvDiagonal.remove(r - c);
            board[r][c] = '.';
        }
    }
}
