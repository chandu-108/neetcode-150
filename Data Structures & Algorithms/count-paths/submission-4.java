class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        dp[0][0]=0;
        if(m==1 && n==1) return 1;
        //Fill first row with 1 except the (0,0)
        for(int col=1;col<n;col++){
            dp[0][col]=1;
        }
        //Fill first col with 1 except the (0,0)
        for(int row=1;row<m;row++){
            dp[row][0]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
