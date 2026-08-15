class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,n,m,text1,text2,dp);
    }
    public int func(int i,int j,int n,int m,String text1,String text2,int dp[][]){
    if(i==n || j==m){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
   if(text1.charAt(i)==text2.charAt(j)){
     return 1+func(i+1,j+1,n,m,text1,text2,dp);
    }
    return dp[i][j]=Math.max(func(i+1,j,n,m,text1,text2,dp),func(i,j+1,n,m,text1,text2,dp));
    }
}
