class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int []result=new int[n];
        int idx=0;
        for(int i=0;i<n-1;i++){
          for(int j=i+1;j<n;j++){
            if(temperatures[j]>temperatures[i]){
                result[i]=j-i;
                break;
            }
          }
        }
        return result;
    }
}
