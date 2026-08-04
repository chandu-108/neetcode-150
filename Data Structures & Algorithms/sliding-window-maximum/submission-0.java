class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n=nums.length;
    int result[]=new int[n-k+1];    
    int idx=0;
    for(int i=0;i<=n-k;i++){
        int maxi=nums[i];

        for(int j=i;j<i+k;j++){
          maxi=Math.max(nums[j],maxi);
        }
        result[idx++]=maxi;
    }
    return result;
    }
}
