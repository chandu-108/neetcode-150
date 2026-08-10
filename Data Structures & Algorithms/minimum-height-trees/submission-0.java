class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();

        if(n == 1){
            result.add(0);
            return result;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int degree[] = new int[n];

        for(int edge[] : edges){

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all leaves
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        int remaining = n;

        while(remaining > 2){

            int size = q.size();

            remaining -= size;

            for(int i = 0; i < size; i++){

                int curr = q.poll();

                for(int neighbor : adj.get(curr)){

                    degree[neighbor]--;

                    if(degree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }

        while(!q.isEmpty()){
            result.add(q.poll());
        }

        return result;
    }
}