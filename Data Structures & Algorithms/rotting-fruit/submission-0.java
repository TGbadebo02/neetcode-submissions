class Solution {
    public int orangesRotting(int[][] grid) {
        // set the base case.
        if (grid.length == 0 || grid.length > 10)
            return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }

                if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length
                        || grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.add(new int[] {nr, nc});
                    fresh--;
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
