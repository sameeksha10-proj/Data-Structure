//Minimum time taken to burn Tree from a node 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null }
 * }
 **/

class Solution {
    private static int finalMaxDistance(HashMap<TreeNode,TreeNode> mpp, TreeNode target)
    {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode,Integer> vis= new HashMap<>();
        vis.put(target,1);
        int maxi=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            int fl=0;

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left != null && vis.get(node.left)==null)
                {
                    fl=1;
                    vis.put(node.left,1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right)==null)
                {
                    fl=1;
                    vis.put(node.right,1);
                    q.offer(node.right);
                }
                if(mpp.get(node)!=null && vis.get(mpp.get(node))==null)
                {
                    fl=1;
                    vis.put(mpp.get(node),1);
                    q.offer(mpp.get(node));

                }
            }
            if(fl==1)
            {
                maxi++;
            }
        }

     return maxi;
    }
    private static TreeNode bfsToMapParents(TreeNode root,HashMap<TreeNode,TreeNode> mpp,int start)
    {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node.data==start)
                res=node;
            if(node.left!=null)
            {
                mpp.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                mpp.put(node.right,node);
                q.offer(node.right);
            }
        }
        return res;
    }
    public int timeToBurnTree(TreeNode root, int start) {
       HashMap<TreeNode,TreeNode> mpp= new HashMap<>();
       TreeNode target = bfsToMapParents(root,mpp,start);
       int maxi=finalMaxDistance(mpp,target);
       return maxi;
    }
}
