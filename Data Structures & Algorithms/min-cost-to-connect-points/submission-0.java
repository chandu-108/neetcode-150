class Solution {
    public class Edge{
       int u;
       int v;
       int weight;

       Edge(int u,int v,int weight){
        this.u=u;
        this.v=v;
        this.weight=weight;
       }
    }
    int parent[];
    int rank[];
    public int find(int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=find(parent[u]);
    }
    public void unionbyrank(int u,int v){
        int pu=find(u);
        int pv=find(v);

        if(pu==pv){
            return;
        }

        if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        }else if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        ArrayList<Edge>edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int weight=Math.abs(x1-x2)+Math.abs(y1-y2);
                edges.add(new Edge(i,j,weight));
            }
        }
        edges.sort((a,b)->a.weight-b.weight);
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int mstweight=0;
        int edgetaken=0;

        for(Edge edge: edges){
           int pu=find(edge.u);
           int pv=find(edge.v);
           
           if(pu!=pv){
            mstweight+=edge.weight;
            
            unionbyrank(pu,pv);

            edgetaken++;

            if(edgetaken==n-1){
               break;
            }
           }
        }
        return mstweight;
    } 
}
