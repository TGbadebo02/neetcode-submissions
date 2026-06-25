class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //base case. 
        if(grid.length == 0) return 0;

        int maxArea = 0; 

        //traverse through the grid, for each cell.
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int curArea = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int i, int j, int [][] grid){
        //set the base case.
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(i + 1, j, grid) +
        dfs(i - 1, j, grid) +
        dfs(i, j + 1, grid) +
        dfs(i, j - 1, grid);

    }
}
