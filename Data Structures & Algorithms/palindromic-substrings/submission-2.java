class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int cnt=0;

        for(int i=0;i<n;i++){
            //ODD length
            cnt+=func(i,i,s);
            //EVEN length
            cnt+=func(i,i+1,s);
        }
        return cnt;
    }
    public int func(int i,int j,String s){
        int count =0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}
