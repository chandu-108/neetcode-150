class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};

    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Pair>q=new LinkedList<>();
        //This is multi source BFS 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            
            for(int d[]:dir){
                int newrow=d[0]+row;
                int newcol=d[1]+col;

                if(newrow>=0 && newcol>=0 && newrow < n && newcol < m && grid[newrow][newcol]==Integer.MAX_VALUE){
                grid[newrow][newcol]=grid[row][col]+1;
                q.offer(new Pair(newrow,newcol));
                }
            }

        }
    }
}
