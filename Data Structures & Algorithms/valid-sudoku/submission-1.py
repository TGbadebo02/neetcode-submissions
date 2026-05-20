class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #set = set()
        #for i in range(board):
           # row = board[i]
           ## for j in range(row): 
            # if(!set.add(j)):
              # return true
            
            #return false
        column = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set)


        for i in range(9):
            for j in range(9):
                #edge case for an empty squaare
                if board[i][j] ==".":
                    continue
                #average case where a duplicate is found
                #in either the row, column or square.
                if( board[i][j] in rows[i]
                   or board[i][j] in column[j]
                   or board[i][j] in squares[(i//3, j//3)]):
                   return False

                #if there isn't a duplicate, then add the either value to the hashset
                rows[i].add(board[i][j])
                column[j].add(board[i][j])
                squares[(i//3,j//3)].add(board[i][j])
                
        return True
            
