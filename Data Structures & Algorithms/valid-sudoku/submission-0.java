class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        //ROWS Checking
        for(int i=0;i<n;i++){
            HashSet<Character>Rowset=new HashSet<>();
            for(int j=0;j<m;j++){
                if(board[i][j]=='.') continue;
                if(Rowset.contains(board[i][j])) return false;
                Rowset.add(board[i][j]);
            }
        }
        //COLUMNS Checking
         for(int i=0;i<n;i++){
            HashSet<Character>Colset=new HashSet<>();
            for(int j=0;j<m;j++){
                if(board[j][i]=='.') continue;
                if(Colset.contains(board[j][i])) return false;
                Colset.add(board[j][i]);
            }
        }
        //3x3 Matrix Checking
        for(int row=0;row<n;row+=3){
            for(int col=0;col<m;col+=3){
                HashSet<Character>set=new HashSet<>();
                for(int i=row;i<row+3;i++){
                for(int j=col;j<col+3;j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
            }
        }

        return true;
    }
}
