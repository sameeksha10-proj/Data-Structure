#brute:
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int nge[]=new int[n];
        Arrays.fill(nge,-1);

        for(int i=0;i<=n-1;i++)
        {
            for(int j=i+1; j<=i+(n-1);j++)
            {
                int ind = j % n;
                if(arr[ind] > arr[i])
                {
                    nge[i] = arr [ind];
                    break;
                }
            }
        }
    return nge;   
    }
}
#optimal:
class Solution {
    public int[] nextGreaterElements(int[] nums) {
      int  n=nums.length;
      int nge[]=new int[n];
      Stack<Integer> st= new Stack<>();
    

      for(int i=2*n-1;i>=0;i--){
        while(!st.empty() && st.peek()<=nums[i % n])
        {
            st.pop();
        }
        if(i<n){
        if(st.empty())
            nge[i]=-1;
        else 
            nge[i]=st.peek();
        }
        st.push(nums[i % n]);
      }
    return nge;
    }
}
