class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];

        int first=0;
        int last=0;
        int maxi=0;

        for(int i=n-1;i>=0;i--){
            dp[i][i]=true;

            for(int j=i;j<n;j++){
                if(s.charAt(j)==s.charAt(i)){
                    if(j-i<=1 || dp[i+1][j-1]){
                      dp[i][j]=true;

                      int len=j-i+1;

                      if(len > maxi){
                        maxi=len;
                        first=i;
                        last=j;
                      }
                    }
                }
            }
        }
        return s.substring(first,last+1);
    }
}
