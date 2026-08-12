class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return func(0,nums,n,dp);
    }
    public int func(int i,int nums[],int n,int dp[]){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+func(i+2,nums,n,dp);
        int nottake=func(i+1,nums,n,dp);

        return dp[i]=Math.max(take,nottake);
    }
}
