class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,n,m,grid,dp);
    }
    public int func(int i,int j,int n,int m,int[][] grid,int[][] dp){
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(i<0 || j<0 || i>=n || j>=m){
            return 1000000000;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=grid[i][j]+func(i,j+1,n,m,grid,dp);
        int down=grid[i][j]+func(i+1,j,n,m,grid,dp);

        return dp[i][j]=Math.min(left,down);
    }
}