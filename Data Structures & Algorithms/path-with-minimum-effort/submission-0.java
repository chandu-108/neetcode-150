class Solution {
    public class Pair{
        int effort;
        int row;
        int col;

        Pair(int effort,int row,int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
       PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.effort-b.effort);
       pq.add(new Pair(0,0,0));
       int n=heights.length;
       int m=heights[0].length;
       int distance[][]=new int[n][m];
       for(int i=0;i<n;i++){
        Arrays.fill(distance[i],Integer.MAX_VALUE);
       }
       distance[0][0]=0;
       while(!pq.isEmpty()){
        Pair curr=pq.poll();
        int effort=curr.effort;
        int row=curr.row;
        int col=curr.col;
        if(row==n-1 && col==m-1) return effort;
        for(int d[]:dir){
            int newrow=row+d[0];
            int newcol=col+d[1];

            if(newrow>=0 && newcol>=0 && newrow< n && newcol < m){
                int difference=Math.abs(heights[newrow][newcol]-heights[row][col]);       
            int newEffort=Math.max(effort,difference); 
            if(newEffort < distance[newrow][newcol]){
              distance[newrow][newcol]=newEffort;
              pq.offer(new Pair(newEffort,newrow,newcol));
            }
            }
        }
       }
       return 0;
    }
}