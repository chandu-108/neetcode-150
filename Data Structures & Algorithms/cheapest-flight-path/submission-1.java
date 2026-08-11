class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     for(int flight[]:flights){
        int u=flight[0];
        int v=flight[1];
        int price=flight[2];

        adj.get(u).add(new int[]{v,price});
     }
     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
     pq.offer(new int[]{0,src,0});
     int distance[][]=new int[n][k+2];
     for(int i=0;i<n;i++){
     Arrays.fill(distance[i],Integer.MAX_VALUE);
     }
     distance[src][0]=0;
     while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int node=curr[1];
        int price=curr[0];
        int stops=curr[2];
        if(node==dst) return price;
        if(stops > k){
            continue;
        }
        for(int[] neighbor: adj.get(node)){
            int newnode=neighbor[0];
            int newprice=neighbor[1];

            int totalprice=newprice+price;
             
            if(totalprice < distance[newnode][stops+1]){
                distance[newnode][stops+1]=totalprice;
                pq.offer(new int[] {totalprice,newnode,stops+1});
            }
        }
     }
     return -1;
    }
}
