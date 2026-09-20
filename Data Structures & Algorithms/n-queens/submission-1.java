class Solution {
    // create the result list here and sets.
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cellSet = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] array = new char[n][n];

        for (char[] row : array) {
            Arrays.fill(row, '.');
        }
        // call the back track function.
        backTrack(0, n, array);
        // return result.list.
        return result;
    }

    // define function w parameters index, list, n
    public void backTrack(int r, int n, char[][] array) {
        // if the index equals to n, add to result list and return void.
        if (r == n) {
           List<String> list = new ArrayList<>();
            for (char[] row : array) {
                list.add(new String(row));
            }
            result.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cellSet.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            array[r][c] = 'Q';
            cellSet.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            backTrack(r + 1, n, array);

            array[r][c] = '.';
            cellSet.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
        // iterate through the colums
        // check if its not all ready in the sets.
        // add them.
        // after call the function from the next column and then back track.
    }
}
