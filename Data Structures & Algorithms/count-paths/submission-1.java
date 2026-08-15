class Solution {
    public int uniquePaths(int m, int n) {
     int dp[][]=new int[m+1][n+1];
     for(int i=0;i<m;i++){
        Arrays.fill(dp[i],-1);
     }
     return helper(0,m,0,n,dp);   
    }
    public int helper(int i,int m,int j,int n,int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i<0 || i>=m || j<0 || j>=n ){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=helper(i,m,j+1,n,dp);
        int down=helper(i+1,m,j,n,dp);

        return dp[i][j]=left+down;        
    }
}
