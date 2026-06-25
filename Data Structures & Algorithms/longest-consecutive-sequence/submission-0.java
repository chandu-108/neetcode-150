class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int maxi=0;
        HashSet<Integer>set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int curr=num;
                int len=1;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxi=Math.max(maxi,len);
            }
        }
    return maxi;   
    }
}
