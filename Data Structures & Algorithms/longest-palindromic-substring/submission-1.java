class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxi=0;
        if(n==1) return s;
        int first=0,last=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    int len=j-i+1;
                    if(len > maxi){
                        first=i;
                        last=j;
                        maxi=len;
                    }
                }
            }
        }
        return s.substring(first,last+1);
    }
    public boolean isPalindrome(int i,int j,String s){
        if(i>=j){
            return true;
        }

        if(s.charAt(i)==s.charAt(j)){
            return isPalindrome(i+1,j-1,s);
        }
        else{
            return false;
        }
        // return true;
    }
}
