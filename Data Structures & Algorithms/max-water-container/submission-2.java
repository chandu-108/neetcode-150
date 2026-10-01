class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int maxi=0;
        int left=0;
        int right=n-1;
        while(left < right){
         int width=right-left;
         int mini=Math.min(heights[left],heights[right]);
         maxi=Math.max(mini*width,maxi);
         if(heights[left]<heights[right]){
            left++;
         }else{
            right--;
         }
        }
        return maxi; 
    }
}
