class Solution {
    int n;
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int diff=helper(stoneValue,0,dp);

        if(diff > 0){ //Alice-Bob > 0
            return "Alice";
        }else if(diff < 0){
            return "Bob"; //Alice-Bob < 0
        }
        return "Tie";
    }
    public int helper(int[] stoneValue,int i,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result=stoneValue[i]-helper(stoneValue,i+1,dp);

        if(i+1 <n){
         result=Math.max(result,stoneValue[i]+stoneValue[i+1]-helper(stoneValue,i+2,dp));
        }
        if(i+2<n){
            result=Math.max(result,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-helper(stoneValue,i+3,dp));
        }
        return dp[i]=result;
    }
}