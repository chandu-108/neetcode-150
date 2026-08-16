class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int alice_stones=helper(0,n-1,piles,dp);
        int bob_stones=sum-alice_stones;
        if(alice_stones > bob_stones){
            return true;
        }
        return false;
    }
    public int helper(int i,int j,int[] piles,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take_i=piles[i]+Math.min(helper(i+2,j,piles,dp),helper(i+1,j-1,piles,dp));
        int take_j=piles[j]+Math.min(helper(i+1,j-1,piles,dp),helper(i,j-2,piles,dp));


        return dp[i][j] = Math.max(take_i, take_j);
    }
}