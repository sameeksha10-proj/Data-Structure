//brute
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n=heights.length;
        

        int[] nse=nextSmallerElement(heights,n);
        int[] psee=previousSmallerElement(heights,n);

        int maxi=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,heights[i]*(nse[i]-psee[i]-1));
        }
       
        return maxi;
    }
     private int[] nextSmallerElement (int[] arr,int n){
        int[] nse=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                int idx=st.pop();
                nse[idx]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nse[st.pop()]=n;
        }
    return nse;
    }
     private int[] previousSmallerElement(int[] arr,int n){
        int[] psee=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
                psee[i]=-1;
            else 
                psee[i]=st.peek();
            
            st.push(i);
        }
    return psee;
    }
}
//optimal
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();

        int maxArea=0;
        int element=0;
        int nse=0;
        int pse=0;

        //int[] nse=nextSmallerElement(heights,n);
        //int[] psee=previousSmallerElement(heights,n);

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()] > heights[i])
            {
                element=st.peek();
                st.pop();
                
                nse=i;
                pse=st.isEmpty()?-1:st.peek();

                maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);

            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nse=n;
            element=st.peek();
            st.pop();
            pse=st.empty()?-1:st.peek();

            maxArea=Math.max(maxArea,(nse-pse-1)*heights[element]);
        }
    return maxArea;
    }
    
}
