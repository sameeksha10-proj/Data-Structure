class Solution {
    
    private void dfsRec(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res,boolean[] vis)
    {
        vis[node]=true;
        res.add(node);
        
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfsRec(it,adj,res,vis);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V=adj.size();
        boolean visited[]=new boolean[V+1];
        ArrayList<Integer>res= new ArrayList<>();
        dfsRec(0,adj,res,visited);
        return res;  
    }
}
