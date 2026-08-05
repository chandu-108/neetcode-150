class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n==0) return true;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                return false;
                }
                char top=st.peek();
                   if(s.charAt(i)==')' && top=='(' ||
                      s.charAt(i)==']' && top=='[' ||
                      s.charAt(i)=='}' && top=='{'){
                        st.pop();
                      }else{
                        return false;
                      } 
                }
        }
        return st.isEmpty() ? true: false;
    }
}
