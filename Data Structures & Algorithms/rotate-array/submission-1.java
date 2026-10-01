class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        flip(0,n-1,nums);
        flip(0,k-1,nums);
        flip(k,n-1,nums);
    }
    public void flip(int left,int right, int[] nums){
        while(left<=right){
            int temp=nums[left];
            nums[left]=nums[right];
nums[right]=temp;

left++;
right--;
        }
    }
}