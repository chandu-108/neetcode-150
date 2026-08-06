class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int start=nums[0];
        int end=nums[n-1];
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
             if(nums[i]<nums[i-1] && nums[i] < nums[i+1]){
              mini=Math.min(nums[i],mini);
             }
        }
        if(start > mini && mini < end){
            return mini;
        }else if(start < mini && start < end){
            return start;
        }
        return end;
    }
}
