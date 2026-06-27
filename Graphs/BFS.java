class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
        boolean[] vis= new boolean[V];
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        vis[0]=true;
        
       while(!q.isEmpty())
       {
           int curr=q.poll();
           res.add(curr);
       
       for(int x:adj.get(curr))
       {
           if(!vis[x])
           {
               vis[x]=true;
               q.add(x);
           }
       }
    }
       return res;
    }
}
