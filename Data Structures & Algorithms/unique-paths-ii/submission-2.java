class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        int[][] dp=new int[n+1][m+1];
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0]=1;

        //Filling the First row 
        for(int col=1;col<m;col++){
            if(obstacleGrid[0][col] == 1){
                dp[0][col]=0;
            }else{
                dp[0][col]=dp[0][col-1];
            }
        }
        //Filling the First Col
        for(int row=1;row<n;row++){
            if(obstacleGrid[row][0] == 1){
                dp[row][0]=0;
            }else{
                dp[row][0]=dp[row-1][0];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}