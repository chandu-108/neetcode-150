class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
     return helper(0,0,n,m,obstacleGrid,dp);   
    }
    public int helper(int i,int j,int n,int m,int obstacleGrid[][],int[][] dp){
        if(i<0 || j<0 || j>=m || i>=n || obstacleGrid[i][j]==1){
        return 0;
        }
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=helper(i,j+1,n,m,obstacleGrid,dp);
        int down=helper(i+1,j,n,m,obstacleGrid,dp);

        return dp[i][j]=left+down;
    }
}