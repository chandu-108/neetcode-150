class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
         HashMap<Integer,Integer>map=new HashMap<>();
         for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        //now reterving the element which are greater than or equal to the K
        pq.addAll(map.entrySet());
        int ans[]=new int[k];
        
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}
