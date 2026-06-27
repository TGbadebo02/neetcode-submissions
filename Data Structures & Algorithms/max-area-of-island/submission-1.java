class Solution {
    Queue<int[]> queue = new ArrayDeque<>();
    int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        // set the base case.
        if (grid.length == 0)
            return 0;

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int curArea = bfs(i, j, grid, queue);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }


    public int bfs(int i, int j, int [][] grid, Queue<int[]>queue){
        grid[i][j] = 0;
        int count = 1;
        queue.offer(new int[]{i,j});
        
        while(!queue.isEmpty()){
           int [] curcell = queue.poll();
           int row = curcell[0];
           int col = curcell[1];

           for(int [] direction : directions){
               int newRow = row + direction[0];
               int newCol = col + direction[1];

               if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0){
                 continue;
               }
               
               queue.offer(new int[]{newRow,newCol});
               grid[newRow][newCol] = 0;
               count++;
           }
        }
        return count;
    }
}
