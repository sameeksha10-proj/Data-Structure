class Solution {
    List<String> result= new ArrayList<>();

    void solve(String curr,int n,int open,int close){
       
        int m=curr.length();
        if(m==2*n){
            result.add(curr.toString());
            return ;
        }
       if(open<n){
                solve(curr+"(",n,open+1,close);
       }

        if(close<open){
                solve(curr+")",n,open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        String curr="";

        int open=0;
        int close=0;

        solve(curr,n,0,0);

        return result;
    }
}
      
