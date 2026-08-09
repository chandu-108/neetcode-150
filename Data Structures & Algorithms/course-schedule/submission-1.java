class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
         int[] indegree=new int[numCourses];
         for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
         }
         for(int edge[]:prerequisites){
            int u=edge[0];
            int v=edge[1];

            adj.get(v).add(u);

            indegree[u]++;
         }
         Queue<Integer>q=new LinkedList<>();
         for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
         }
         int cnt=0;
         while(!q.isEmpty()){
            int curr=q.poll();
            cnt++;
            for(int neighbor:adj.get(curr)){
                  indegree[neighbor]--;
                  if(indegree[neighbor]==0)
                  q.offer(neighbor);
            }
         }
     return cnt==numCourses;
    }
}
