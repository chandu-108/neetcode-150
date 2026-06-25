class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int maxi=0;
       for(int i=0;i<n-1;i++){
         for(int j=i+1;j<n;j++){
            int width=j-i;
            int height=Math.min(heights[i],heights[j]);

            maxi=Math.max(width*height,maxi);
         }
       }
       return maxi;
    }
}
