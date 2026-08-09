class Solution {
    int parent[];
    int size[];

    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }

    void unionBysize(int u,int v){
        int rootU=find(u);
        int rootV=find(v);

        if(rootU==rootV){
           return;
        }
        
        if(size[rootU]<size[rootV]){
            size[rootV]+=size[rootU];
            parent[rootV]=rootU;
        }else if(size[rootU] > size[rootV]){
            size[rootU]+=size[rootV];
            parent[rootU]=rootV;
        }else{
            size[rootV]+=size[rootU];
            parent[rootV]=rootU;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int result[]=new int[2]; 
        parent=new int[n+1];
        size=new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int edge[]: edges){
        int u=edge[0];
        int v=edge[1];
        if(find(u)==find(v)){
            result[0]=u;
            result[1]=v;
            return result;
        }
        unionBysize(u,v);
        }
        return new int[0];
    }
}
