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
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
        {
            return result;
        }
        List<Integer>path = new ArrayList<>();
        getAllPaths(root,path,result);
        return result;
    }
    private void getAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> result)
    {
        if(node==null)
        {
            return;
        }
        path.add(node.data);
        if(isLeaf(node))
        {
            result.add(new ArrayList<>(path));
        }
        else
        {
            getAllPaths(node.left,path,result);
            getAllPaths(node.right,path,result);
        }
        path.remove(path.size()-1);
    }
    private boolean isLeaf(TreeNode node)
    {
        return node.left==null && node.right==null;
    }
}
