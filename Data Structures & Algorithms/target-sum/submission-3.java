class Solution {
    int n;
    int sum=0;
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
         int dp[][]=new int[n+1][2*sum+1];
          for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,target,nums,dp);
    }
    public int helper(int idx,int currSum,int target,int nums[],int[][] dp){
        if(idx==n){
            if(currSum==target){
                return 1;
            }
            return 0;
        }
        if(dp[idx][currSum+sum]!=-1){
            return dp[idx][currSum+sum];
        }
        int plus=helper(idx+1,currSum+nums[idx],target,nums,dp);
        int minus=helper(idx+1,currSum-nums[idx],target,nums,dp);

        return dp[idx][currSum+sum]=plus+minus; 
    }
}
