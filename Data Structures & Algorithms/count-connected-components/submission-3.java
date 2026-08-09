class Solution {
    int parent[];
    int size[];

    int find(int node){
        if(parent[node]==node){
            return node;
        }

        return parent[node]=find(parent[node]);
    }
    
    void unionSize(int u,int v){
        int rootU=find(u);
        int rootV=find(v);

        if(rootU==rootV){
            return;
        }

        if(size[rootU]<size[rootV]){
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }else if(size[rootU] > size[rootV]){
            parent[rootV]=rootU;
            size[rootU]+=size[rootV];
        }else{
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }
    }
    public int countComponents(int n, int[][] edges) {
     parent=new int[n];
     size=new int[n];
     int cnt=n;
     for(int i=0;i<n;i++){
        parent[i]=i;
        size[i]=1;
     }
     for(int edge[]:edges){
        int u=edge[0];
        int v=edge[1];

        if(find(u)!=find(v)){
            unionSize(u,v);
            cnt--;
        }
     }
     return cnt;
    }
}
