class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
       int n=s1.length();
       int m=s2.length();
       int len=s3.length();
       Boolean[][] dp=new Boolean[n+1][m+1];
       if(len!=n+m){
        return false;
       }
       return helper(0,0,n,m,s1,s2,s3,dp);
    }
    public boolean helper(int i,int j,int n,int m,String s1, String s2, String s3,Boolean[][] dp){
        if(i==n && j==m){
          return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int k=i+j;

        boolean first=false;
        boolean second=false;

        if(i<n && s1.charAt(i)==s3.charAt(k)){
        first = helper(i+1,j,n,m,s1,s2,s3,dp);
        }
        if(j<m && s2.charAt(j)==s3.charAt(k)){
        second=helper(i,j+1,n,m,s1,s2,s3,dp);
        }
        return dp[i][j]=first || second;
    }
}
