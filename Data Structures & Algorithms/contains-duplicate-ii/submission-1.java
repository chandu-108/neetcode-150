class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        int diff=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int preIdx=map.get(nums[i]);
                if(i-preIdx <=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}