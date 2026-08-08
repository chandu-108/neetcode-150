class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int result=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    if(!visited[i][j]){
                    result++;
                    dfs(i,j,grid,visited);
                    }
                }
            }
        }
        return result;
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(int row,int col,char[][] grid,boolean[][] visited){
        visited[row][col]=true;
        for(int d[]:dir){
            int newrow=d[0]+row;
            int newcol=d[1]+col;

            if(newrow >=0 && newcol >=0 && newrow < grid.length && newcol < grid[0].length && !visited[newrow][newcol] && grid[newrow][newcol]=='1'){
                dfs(newrow,newcol,grid,visited);
            }
        }
    }
}
