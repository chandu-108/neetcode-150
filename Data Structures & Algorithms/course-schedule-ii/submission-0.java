class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
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
        int idx=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            result[idx++]=curr;
             
            for(int neighbor:adj.get(curr)){
            indegree[neighbor]--;
            if(indegree[neighbor]==0){
                q.offer(neighbor);
            }
            }
        }

        return (idx==numCourses)? result:new int[0];
    }
}
