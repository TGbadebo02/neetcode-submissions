class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                 if(grid[i][j] == '1'){
                    count++;
                    queue.offer(new int[]{i,j});
                    grid[i][j] = '0';
                 }


                 while(!queue.isEmpty()){
                    int [] cell = queue.poll();
                    int row = cell[0];
                    int col = cell[1];

                    for(int [] dirct : directions){
                        int newRow = row + dirct[0];
                        int newCol = col + dirct[1];

                        if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == '0'){
                            continue;
                        }

                        grid[newRow][newCol] = '0';
                        queue.offer(new int[]{newRow,newCol});
                    }
                 }
            }
        }
        return count;
      }
    }
