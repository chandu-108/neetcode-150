class Solution {
    public boolean validTree(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
     int components=0;
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     for(int edge[]:edges){
        int u=edge[0];
        int v=edge[1];

        adj.get(u).add(v);
        adj.get(v).add(u);
     }
     boolean[] visited=new boolean[n];
     for(int i=0;i<n;i++){
        if(!visited[i]){
            components++;
           if(dfs(i,-1,visited,adj)){
            return false;
           }
        }
     }
     return components==1;
    }
    public boolean dfs(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;

        for(int neightbor: adj.get(node)){
            if(!visited[neightbor]){
                 if(dfs(neightbor,node,visited,adj)){
                    return true;
                 }
            }else if(neightbor!=parent){
                return true;
            }
        }
        return false;
    }
}
