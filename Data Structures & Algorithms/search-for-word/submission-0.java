class Solution {
    Set<String> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
    //iterate through the cells in the board.
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length;j++){
            if(backTrack(i,j,word,board,0)){
                return true;
            }
        }
     }
     return false;
    }

    public boolean backTrack(int row, int col, String word, char [][] array, int index){
        //set base case(s).
        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= array.length || col < 0 || col > array.length || word.charAt(index) != array[row][col]){
            return false;
        }
        
        String key = row + "," + col;
        if(visited.contains(key)){
            return false;
        }
        visited.add(key);
       
        boolean isfound = backTrack(row + 1, col, word, array, index + 1) ||
            backTrack(row - 1, col, word, array, index + 1) ||
            backTrack(row, col + 1, word, array, index + 1) ||
            backTrack(row, col - 1, word, array, index + 1);
        
        visited.remove(key);

        return isfound;
    }
}
