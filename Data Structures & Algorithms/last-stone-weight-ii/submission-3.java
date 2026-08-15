class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int total=0;
        for(int stone:stones){
            total+=stone;
        }
        int target=total/2;
        int[][] dp=new int[n+1][target+1];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
        }
        int sum=helper(0,target,stones,dp);

        return total-2*sum;
    }
    public int helper(int idx,int target,int stones[],int[][] dp){
        if(idx==stones.length || target == 0){
            return 0;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        int take=0;
        if(stones[idx]<=target){
            take=stones[idx]+helper(idx+1,target-stones[idx],stones,dp);
        }
        int skip=helper(idx+1,target,stones,dp);

        return dp[idx][target]=Math.max(take,skip);
    }
}