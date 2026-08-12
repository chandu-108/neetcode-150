class Solution {
    int dp[];
    public int climbStairs(int n) {
        
         dp=new int[n+1];
         Arrays.fill(dp,-1);
        return func(n);
    }
    public int func(int n){
        if(n==1) return 1;
        if(n==2) return 2;
      
        if(dp[n]!=-1){
            return dp[n];
        }
       return dp[n]=func(n-1)+func(n-2);
    }
}
