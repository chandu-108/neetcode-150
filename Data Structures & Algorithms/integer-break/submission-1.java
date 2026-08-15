class Solution {
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n,int[] dp){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int mult=Integer.MIN_VALUE;
        for(int i=1;i<=n-1;i++){
            int result=i*Math.max(n-i,helper(n-i,dp));
            mult=Math.max(mult,result);
        }
        return dp[n]=mult;
    }
}