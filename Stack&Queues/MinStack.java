//brute
class MinStack {

    Stack<int []> st;

    public MinStack() {
        st=new Stack<>();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(new int[]{x, x});
        } else {
            int currentMin = Math.min(x, st.peek()[1]);
            st.push(new int[]{x, currentMin});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {

         return st.peek()[1];
        
    }
}


//optimized
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
//testcases
//case 1
Nums
[[1,-2], [1,0], [1,-3], [3 ], [ 2], [4], [3] ]
Your Output
-3 0 -2
Expected Output
-3 0 -2

//case 2
Nums
[ [1,5], [1,1], [3 ], [1,3], [2], [3], [4] ]
Your Output
1 1 1
Expected Output
1 1 1

//case 3
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Expected
[null,null,null,null,-3,null,0,-2]

