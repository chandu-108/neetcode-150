class Solution {
    int n;
    HashSet<String>set;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        set=new HashSet<>(wordDict);
        dp=new Boolean[n];
        return func(0,s);
    }
    public boolean func(int i,String s){
        if(i==n){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        for(int j=i;j<n;j++){
            String word=s.substring(i,j+1);
            if(set.contains(word)){
              if(func(j+1,s)){
                return dp[i]=true;
              }
            }
        }
        return dp[i]=false;
    }
}
