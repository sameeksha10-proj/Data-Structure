class MinStack {

    Stack<Long>st=new Stack<Long>();
    Long mini;

    public MinStack() {
        mini=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value=Long.valueOf(val);
        if(st.isEmpty())
        {
            mini=value;
            st.push(value);
        }
        else if(value > mini)
        {
            st.push(value);
        }
        else 
        {
            st.push(2*value - mini);
            mini=value;
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;

        Long x=st.pop();
        if(x < mini)
        {
            mini=2*mini - x;
        }
    }
    
    public int top() {
         if(st.isEmpty())
            return 0;
        Long x=st.peek();
        if(mini < x)
        {
            return x.intValue();
        }
        return mini.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
