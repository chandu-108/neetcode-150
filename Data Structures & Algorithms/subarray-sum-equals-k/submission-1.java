class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int cnt=0;
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();

        map.put(0,1);

        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}