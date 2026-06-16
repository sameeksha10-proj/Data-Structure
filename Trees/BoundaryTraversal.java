/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public List<Integer> boundary(TreeNode root) {
        return printBoundry(root);
    }
    boolean isLeaf(TreeNode node)
    {
        if(node == null)
        {
            return false;
        }
        if(node.left==null && node.right==null)
            return true;
        else 
            return false;
    }
    private void addLeft(TreeNode node, ArrayList<Integer> res)
    {
        TreeNode cur=node.left;
       while(cur!=null)
       {
            if(isLeaf(cur)==false)
            {
                res.add(cur.data);
            }
            if(cur.left!=null)
                cur=cur.left;
            else
                cur=cur.right;
       }

    }
    private void addRight(TreeNode node, ArrayList<Integer> res)
    {
        TreeNode cur=node.right;
        ArrayList<Integer> tmp=new ArrayList<>();
       while(cur!=null)
       {
            if(isLeaf(cur)==false)
            {
                tmp.add(cur.data);
            }
            if(cur.right!=null)
                cur=cur.right;
            else
                cur=cur.left;
       }
       for(int i=tmp.size()-1;i>=0;i--)
       {
            res.add(tmp.get(i));
       }
       }
    void addLeaves(TreeNode node,ArrayList<Integer> res)
    {
        if(node == null)
        {
            return;
        }
        if(isLeaf(node))
        {
            res.add(node.data);
            return;
        }
        if(node.left!=null)
                addLeaves(node.left,res);
        if(node.right!=null)
                addLeaves(node.right,res);
    }

    ArrayList<Integer> printBoundry(TreeNode node)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        if(node == null)
        {
            return ans;
        }
       
        if(isLeaf(node)==false)
        {
            ans.add(node.data);
        }
        addLeft(node,ans);
        addLeaves(node,ans);
        addRight(node,ans);
        
        return ans;
    }
}
