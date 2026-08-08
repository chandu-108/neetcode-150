class Solution {
    int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         n=heights.length;
         m=heights[0].length;
        List<List<Integer>>result=new ArrayList<>();
        boolean[][] isPacific=new boolean[n][m];
        boolean[][] isAtlantic=new boolean[n][m];

        for(int i=0;i<n;i++){
            pacificdfs(i,0,heights,isPacific);
        }

        for(int j=0;j<m;j++){
            pacificdfs(0,j,heights,isPacific);
        }

        for(int i=n-1;i>=0;i--){
            atlanticdfs(i,m-1,heights,isAtlantic);
        }

        
        for(int j=m-1;j>=0;j--){
            atlanticdfs(n-1,j,heights,isAtlantic);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isPacific[i][j] && isAtlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public void pacificdfs(int row,int col,int heights[][],boolean[][] isPacific){
        isPacific[row][col]=true;
        for(int d[]:dir){
        int newrow=row+d[0];
        int newcol=col+d[1];

        if(newrow>=0 && newcol>=0 && newrow < n && newcol < m && !isPacific[newrow][newcol] && heights[newrow][newcol]>=heights[row][col]){
        pacificdfs(newrow,newcol,heights,isPacific);
        }
        }
    }

    public void atlanticdfs(int row,int col,int heights[][],boolean[][] isAtlantic){
        isAtlantic[row][col]=true;
        for(int d[]:dir){
        int newrow=row+d[0];
        int newcol=col+d[1];

        if(newrow>=0 && newcol>=0 && newrow < n && newcol < m && !isAtlantic[newrow][newcol] && heights[newrow][newcol]>=heights[row][col]){
       atlanticdfs(newrow,newcol,heights,isAtlantic);
        }
        }
    }
}
