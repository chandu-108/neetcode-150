class Solution {
    int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int distance[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currTime=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row==n-1 && col==n-1) return currTime;
            if(currTime > distance[row][col]) continue;

            for(int d[]: dir){
                int newrow=row+d[0];
                int newcol=col+d[1];

                if(newrow>=0 && newcol>=0 && newrow<n && newcol<n){
                    int nextTime=Math.max(currTime,grid[newrow][newcol]);
                    if(nextTime < distance[newrow][newcol]){
                        distance[newrow][newcol]=nextTime;
                        pq.offer(new int[]{nextTime,newrow,newcol});
                    }
                }
            }

        }
        return -1;
    }
}
