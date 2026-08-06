class Solution {
    int maxi;
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(piles[i],maxi);
        }
        int left=1;
        int right=maxi;
        while(left<=right){
            int mid=left+(right-left)/2;
            boolean possible=EatingSpeed(mid,piles,h);
            if(possible){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean EatingSpeed(int k,int[] piles,int h){
    int time=0;
    for(int i=0;i<piles.length;i++){
    time+=Math.ceil((double)piles[i]/k);
    }
    if(time<=h){
        return true;
    }
    return false;
    }
}
