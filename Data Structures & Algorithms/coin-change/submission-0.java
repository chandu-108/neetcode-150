class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans=func(0,coins,amount,n);
        if(ans==100000){
            return -1;
        }
        return ans;
    }
    public int func(int idx,int[] coins,int amount,int n){
      if(idx==n){
        return 100000;
      }
      if(amount==0){
        return 0;
      }
      int take=100000;
      if(amount >= coins[idx]){
       take=1+func(idx,coins,amount-coins[idx],n);
      }
      int nottake=func(idx+1,coins,amount,n);

      return Math.min(take,nottake);
    }
}
