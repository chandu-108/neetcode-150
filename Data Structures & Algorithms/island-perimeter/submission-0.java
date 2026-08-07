class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    class Pair{
        int node;
        int left;
        int right;

        Pair(int node,int left, int right){
            this.node=node;
            this.left=left;
            this.right=right;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        //Finding the staring cell to land
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                q.offer(new Pair(grid[i][j],i,j));
                visited[i][j]=true;
                break;
            }
            }
        }
        
        while(!q.isEmpty()){
            Pair node=q.poll();
            int l=node.left;
            int r=node.right;
            visited[l][r]=true;
            for(int d[]:dir){
                int u=d[0];
                int v=d[1];
                int newrow=u+l;
                int newcol=v+r;
                if(newrow>=n || newrow<0 || newcol>=m || newcol<0){
                    perimeter++;
                }
                 if(newrow<n && newrow>=0 && newcol<m && newcol>=0 && !visited[newrow][newcol]){
                if(grid[newrow][newcol]==0){
                    perimeter++;
                }
                else{
                    visited[newrow][newcol]=true;
                    q.offer(new Pair(grid[newrow][newcol],newrow,newcol));
                }
            }
        }
        }
        return perimeter;
    }
}