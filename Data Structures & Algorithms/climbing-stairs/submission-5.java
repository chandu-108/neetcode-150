class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int start=1;
        int end=1;
        for(int i=2;i<=n;i++){
            int result=start+end;
            start=end;
            end=result;
        }
        return end;
    }
}
