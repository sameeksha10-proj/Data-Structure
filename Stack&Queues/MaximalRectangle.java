class Solution {
    public int maximalRectangle(char[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        int[][] pSum=new int[n][m];

        for(int j=0;j<m;j++)
        {
            int sum=0;
            for(int i=0;i<n;i++)
            {
                
                if(matrix[i][j]=='1')
                {
                    sum++;
                }
                else
                {
                    sum=0;
                }
                pSum[i][j]=sum;
            }

        }
        for(int i=0;i<n;i++)
        {
            maxArea=Math.max(maxArea,largestRectangleArea(pSum[i]));
        }
    return maxArea;
    }
    int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();

        int maxArea=0;
        int element=0;
        int nse=0;
        int pse=0;


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
