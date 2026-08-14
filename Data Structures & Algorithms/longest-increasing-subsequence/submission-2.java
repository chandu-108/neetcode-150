class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
        }
        return func(0,-1,nums,n,dp);
    }
    public int func(int idx,int prev,int nums[],int n,int[][] dp){
        if(idx>=n){
          return 0;
        }
        if(prev!=-1 && dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int take=0;
        if(prev==-1 || nums[prev] < nums[idx]){
            take=1+func(idx+1,idx,nums,n,dp);
        }
        int skip=func(idx+1,prev,nums,n,dp);
        if(prev!=-1){
            dp[idx][prev]=Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}
