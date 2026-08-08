class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxi=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(!visited[i][j]){
                       int cnt=dfs(i,j,grid,visited);
                        maxi=Math.max(cnt,maxi);
                    }
                }
            }
        }
        return maxi;
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int dfs(int row,int col,int[][] grid,boolean[][] visited){
    visited[row][col]=true;
    int cnt=1;
    for(int d[]:dir){
        int newrow=d[0]+row;
        int newcol=d[1]+col;

        if(newrow < grid.length && newcol < grid[0].length && newrow>=0 && newcol>=0 && !visited[newrow][newcol] && grid[newrow][newcol]==1){
        cnt+=dfs(newrow,newcol,grid,visited);
        }
    }
    return cnt;
    }
}
