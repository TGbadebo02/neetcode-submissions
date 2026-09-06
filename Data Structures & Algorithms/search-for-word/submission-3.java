class Solution {
    private HashSet<String> set = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        // set the base case.
        if (board.length == 0 || board.length > 5)
            return false;
        if (word.length() > 10)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, char[][] board, int i, String word) {
        if (i == word.length())
            return true;

        // if (board[row][col] != word.charAt(i))
        //     return false;

        String key = Integer.toString(row) + " " + Integer.toString(col);

        if (row > board.length || row < 0 || col > board[0].length || col < 0 || set.contains(key) || board[row][col] != word.charAt(i)) {
            return false;
        }

        set.add(key);

        boolean isfound = dfs(row + 1, col, board, i + 1, word)
            || dfs(row - 1, col, board, i + 1, word)
            || dfs(row, col + 1, board, i + 1, word)
            || dfs(row, col - 1, board, i + 1, word);

        set.remove(key);

        return isfound;
    }
}
