class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int left=0;
        int mini=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum >= target){
                sum-=nums[left];
                mini=Math.min(mini,right-left+1);
                left++;
            }
        }
        return (mini==Integer.MAX_VALUE) ? 0:mini;
    }
}