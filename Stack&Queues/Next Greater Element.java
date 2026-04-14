#Brute:
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n=arr.length;
        int nge[]=new int[n];
        Arrays.fill(nge,-1); 

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            {
                if(arr[j] > arr[i])
                {
                    nge[i]=arr[j];
                    break;
                }
            }
        }
        return nge;
    }
}
#optimal:
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int nge[]=new int [n];

        for(int i=n-1;i>=0;i--){

            while(!st.empty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.empty())
               nge[i]=-1;
            else 
                nge[i]=st.peek();
        
        st.push(arr[i]);
        }
        return nge;
    }
}
