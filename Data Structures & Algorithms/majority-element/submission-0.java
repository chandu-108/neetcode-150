class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int cnt=0;
        int result=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        if(cnt < entry.getValue()){
         cnt=entry.getValue();
         result=entry.getKey();
        }
        }
        return result;
    }
}