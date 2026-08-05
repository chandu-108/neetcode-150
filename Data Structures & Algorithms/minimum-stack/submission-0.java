class MinStack {
    Stack<Integer>st;
    Stack<Integer>minst;
    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }
    
    public void push(int val) {
        if(minst.isEmpty() || val <= minst.peek()){
            minst.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        int top=st.pop();
        if(top==minst.peek()){
            minst.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
       return minst.peek();
    }
}
