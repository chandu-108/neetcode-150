class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
         
        Queue<int[]>q=new LinkedList<>();
        int freshcnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }
        int time=0;
        while(!q.isEmpty() && freshcnt > 0){
            int size=q.size();
            for(int i=0;i<size;i++){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            
            for(int d[]:dir){
                int newrow=row+d[0];
                int newcol=col+d[1];

                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1){
                    grid[newrow][newcol]=2;
                    freshcnt--;
                    q.offer(new int[]{newrow,newcol});
                }
            }
            }
            time++;
        }
      
    return (freshcnt==0)?time:-1;
    }
}
