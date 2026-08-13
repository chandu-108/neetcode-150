class Solution {
    int maxLen=0;
    int start=0;
    public String longestPalindrome(String s) {
         int n=s.length();
         for(int i=0;i<n;i++){
            //ODD length
            expand(i,i,s);
            //EVEN length
            expand(i,i+1,s);
         }

         return s.substring(start,start+maxLen);
    }
    public void expand(int i,int j, String s){
        if(i<0 || j>=s.length() || s.charAt(i)!=s.charAt(j)){
           return;
        }
            int len=j-i+1;
            if(len > maxLen){
                maxLen=len;
                start=i;
            }
            expand(i-1,j+1,s);
        }
    }
