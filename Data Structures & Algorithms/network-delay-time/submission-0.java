class Solution {
    public class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
       PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.time-b.time);
       int distance[]=new int[n+1];
       Arrays.fill(distance,Integer.MAX_VALUE);
       ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       }
       pq.offer(new Pair(k,0));
       distance[k]=0;
       //Directed Graph
       for(int[] time:times){
        int u=time[0];
        int v=time[1];
        int t=time[2];
        adj.get(u).add(new Pair(v,t));
       }
       
       while(!pq.isEmpty()){
        Pair curr=pq.poll();
        int node=curr.node;
        int time=curr.time;
        
        for(Pair neighbor:adj.get(node)){
        int nextedge=neighbor.node;
        int edgetime=neighbor.time;

        int newtime=edgetime+time;

        if(newtime < distance[nextedge]){
            distance[nextedge]=newtime;
            pq.offer(new Pair(nextedge,newtime));
        }
        }
       }
     int result=Integer.MIN_VALUE;
     for(int i=1;i<=n;i++){
        if(distance[i]==Integer.MAX_VALUE){
            return -1;
        }
        result=Math.max(result,distance[i]);
     }
     return result;
    }
}
