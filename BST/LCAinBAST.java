
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
            return null;
        }
        int curr=root.val;
        if(curr < p.val && curr < q.val)
        {
            lowestCommonAncestor(root.right,p,q);
        }
        if(curr > p.val && curr > q.val)
        {
            lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
