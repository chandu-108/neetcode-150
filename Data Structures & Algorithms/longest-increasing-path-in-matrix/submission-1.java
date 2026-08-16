class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    int n;
    int m;
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    int cnt=dfs(i,j,matrix,dp);
                    maxi=Math.max(cnt,maxi);
            }
        }
        return maxi;
    }
    public int dfs(int row,int col,int[][] matrix,int [][]dp){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=1;
        for(int d[]:dir){
            int newrow=row+d[0];
            int newcol=col+d[1];
          
            if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && matrix[row][col]<matrix[newrow][newcol]){
                int path=dfs(newrow,newcol,matrix,dp);
                count=Math.max(count,1+path);
            }
        }
        return dp[row][col]=count;
    }
}
