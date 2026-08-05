class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
       Stack<Integer>st=new Stack<>();
       int a,b;
       for(String token: tokens){
        switch(token){
        case "+":
         b = st.pop();
         a = st.pop();
        st.push(a+b);
        break;
        

        case "-":
         b = st.pop();
         a = st.pop();
        st.push(a-b);
        break;
        

        case "*":
         b = st.pop();
         a = st.pop();
        st.push(a*b);
        break;
        

        case "/":
         b = st.pop();
         a = st.pop();
        st.push(a/b);
        break;

        default: st.push(Integer.parseInt(token));
       }
       }
       return st.pop();
    }
}
