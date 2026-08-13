class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        Boolean[][] dp=new Boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],null);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s,dp)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isPalindrome(int i,int j,String s,Boolean[][] dp){
        if(i>=j){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
        return dp[i][j]=isPalindrome(i+1,j-1,s,dp);
        }
        return dp[i][j]=false;
    }
}
