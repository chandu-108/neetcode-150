class Solution {
    public void solve(char[][] board) {
     int n=board.length;
     int m=board[0].length;
     //First Row
     for(int j=0;j<m;j++){
        if(board[0][j]=='O'){
        dfs(0,j,board);
     }
     }
     //first col
     for(int i=0;i<n;i++){
         if(board[i][0]=='O'){
        dfs(i,0,board);
         }
     }   
     //Last Row
     for(int j=m-1;j>=0;j--){
         if(board[n-1][j]=='O'){
        dfs(n-1,j,board);
         }
     }
     //Last Col
     for(int i=n-1;i>=0;i--){
         if(board[i][m-1]=='O'){
        dfs(i,m-1,board);
         }
     }

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]=='T'){
                board[i][j]='O';
            }
           else if(board[i][j]=='O'){
                board[i][j]='X';
            }
        }
    }
}
int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
public void dfs(int row,int col,char[][] board){
 board[row][col]='T';
    for(int d[]:dir){
        int newrow=row+d[0];
        int newcol=col+d[1];

        if(newrow>=0 && newcol>=0 && newrow<board.length && newcol<board[0].length &&  board[newrow][newcol]!='T' && board[newrow][newcol]=='O'){
            dfs(newrow,newcol,board);
            
        }
    }
}
}
