class Solution {
    public int countComponents(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     for(int edge[]:edges){
        int u=edge[0];
        int v=edge[1];

        adj.get(u).add(v);
        adj.get(v).add(u);
     }

     int components=0;
     boolean[] visited=new boolean[n];

     for(int i=0;i<n;i++){
        if(!visited[i]){
            components++;
            dfs(i,visited,adj);
        }
     }
     return components;
    }
    public void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,adj);
            }
        }
    }
}
