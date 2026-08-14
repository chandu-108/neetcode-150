class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }
        if(totalsum%2!=0){
           return false;
        }
        int halfsum=totalsum/2;
        Boolean dp[][]=new Boolean[n+1][halfsum + 1];
        return func(0,nums,halfsum,dp);
    }
    public boolean func(int idx,int nums[],int target,Boolean dp[][]){
        if(target < 0 || idx >=nums.length ){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[idx][target]!=null){
         return dp[idx][target];
        }
        boolean take=false;
        if(nums[idx] <= target){
        take=func(idx+1,nums,target-nums[idx],dp);
        }
        boolean nottake=func(idx+1,nums,target,dp);
        return dp[idx][target]=take||nottake;
    }
}
