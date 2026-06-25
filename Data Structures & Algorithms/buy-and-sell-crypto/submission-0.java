class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxi=0;
        //Brute Force Approach
        for(int i=0;i<n-1;i++){
         for(int j=i+1;j<n;j++){
           maxi=Math.max(maxi,prices[j]-prices[i]);
         }
        }
        return maxi;
    }
}
