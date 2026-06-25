class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int MaxProfit=0;
        int mini=prices[0];
        //Optimal Solution
        for(int i=1;i<n;i++){
            mini=Math.min(mini,prices[i]);
            int profit=prices[i]-mini;
            MaxProfit=Math.max(MaxProfit,profit);
        }
        return MaxProfit;
    }
}
