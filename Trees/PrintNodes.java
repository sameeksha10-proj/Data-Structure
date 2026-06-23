//print all nodes at a distance of K from target 
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
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> parent_track,TreeNode Target)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode current=q.poll();
            if(current.left != null)
            {
                parent_track.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null)
            {
                parent_track.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track= new HashMap<>();
        markParents(root,parent_track,root);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target,true);
        int cur_lvl=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            if(cur_lvl == k)
                break;
            cur_lvl++;
            for(int i=0;i<size;i++)
            {
                TreeNode current=queue.poll();
                if(current.left!=null && visited.get(current.left)==null)
                {
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)== null)
                {
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current)!=null && visited.get(parent_track.get(current))==null)
                {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current) , true);
                }

            }
            
        }
        List<Integer> result= new ArrayList<>();
        while(!queue.isEmpty())
        {
            TreeNode current=queue.poll();
            result.add(current.data);
        }
        return result;
    }
}
