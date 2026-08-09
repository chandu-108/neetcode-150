class Solution {

    class Pair{
        String node;
        double value;
        
        Pair(String node,double value){
            this.node=node;
            this.value=value;
        }
    }
    public void dfs(HashMap<String,List<Pair>>adj,String src,String dst,HashSet<String>visited,double product,double ans[]){
        if(visited.contains(src)){
            return;
        }
        visited.add(src);
        if(src.equals(dst)){
            ans[0]=product;
            return;
        }
        for(Pair p:adj.get(src)){
            dfs(adj,p.node,dst,visited,product*p.value,ans);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>>adj=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);

            double value=values[i];

            adj.computeIfAbsent(u,k->new ArrayList<>()).add(new Pair(v,value));
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(new Pair(u,1.0/value));
        }
        double result[]=new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src=queries.get(i).get(0);
            String dst=queries.get(i).get(1);

            double ans[]={-1.0};
            
            if(adj.containsKey(src)){
                HashSet<String>visited=new HashSet<>();
                dfs(adj,src,dst,visited,1.0,ans);
            }
            result[i]=ans[0];
        }
        return result;
    }
}