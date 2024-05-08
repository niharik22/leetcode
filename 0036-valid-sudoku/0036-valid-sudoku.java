class Solution {
    
    public boolean isValidBox(char[][] board, int startRow, int startColumn){
         Set<Character> squareChecker = new HashSet<>();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                char num = board[startRow+i][startColumn+j];
                    if(num!='.' && !squareChecker.add(num)){
                        return false;
                    }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0; i<9; i++){
            Set<Character> rowChecker = new HashSet<>();
            Set<Character> columnChecker = new HashSet<>();
            for(int j = 0; j<9;j++){
                if(board[i][j]!='.' && !rowChecker.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.' && !columnChecker.add(board[j][i])){
                    return false;
                }
            }
        } 
        for(int startRow=0;startRow<9;startRow+=3){
            for(int startColumn = 0; startColumn<9; startColumn+=3){
             if(!isValidBox(board,startRow,startColumn)){
                 return false;
             }   
            }
        }
        return true;
    }
}