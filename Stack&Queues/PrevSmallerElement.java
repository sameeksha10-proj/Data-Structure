class Solution {
    public int[] nextSmallerElements(int[] arr) {
       int n=arr.length;
       int nse[]=new int[n];
       Stack<Integer> st=new Stack<>();
       for(int i=n-1;i >= 0;i--){
        while(!st.isEmpty() && st.peek() >= arr[i])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
            nse[i]=-1;
        }
        else
        {
                nse[i]=st.peek();
        }
        st.push(arr[i]);
       }
    
    return nse;
    }
}
