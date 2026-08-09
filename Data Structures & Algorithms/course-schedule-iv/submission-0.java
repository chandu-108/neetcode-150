class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
        for(int edge[]:prerequisites){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer>q=new LinkedList<>();
        HashSet<Integer>[] preq=new HashSet[numCourses];
        for(int i=0;i<numCourses;i++){
            preq[i]=new HashSet<>();
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int neighbor: adj.get(curr)){
                preq[neighbor].add(curr);
                preq[neighbor].addAll(preq[curr]);

                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }

        List<Boolean>result=new ArrayList<>();
        for(int query[]: queries){
            int u=query[0];
            int v=query[1];

            if(preq[v].contains(u)){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}