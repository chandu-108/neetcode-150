class Solution {
    int n;

    public int maxProfit(int[] prices) {
        n = prices.length;
        int dp[][]=new int[n+1][2];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
        }
        return helper(0, 1, prices,dp);
    }

    public int helper(int idx, int buy, int[] prices,int dp[][]) {
        if (idx >= n) {
            return 0;
        }
        if(dp[idx][buy]!=-1){
          return dp[idx][buy];
        }
        if (buy == 1) {
            int buystock = -prices[idx] + helper(idx + 1, 0, prices,dp);
            int skip = helper(idx + 1, 1, prices,dp);

            return Math.max(buystock, skip);
        } else {
            int sellstock = prices[idx] + helper(idx + 2, 1, prices,dp);
            int skip = helper(idx + 1, 0, prices,dp);

            return dp[idx][buy]=Math.max(sellstock, skip);
        }
    }
}