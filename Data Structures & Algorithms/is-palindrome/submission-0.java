class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st=new StringBuilder();
        int n=s.length();
        for(char ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) {
                st.append(Character.toLowerCase(ch));
            }
        }
        String str=st.toString();
        int right=str.length()-1;
        int left=0;
        char arr[]=str.toCharArray();
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
               return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
