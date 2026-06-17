/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null; }
 * }
 **/

class Solution {
   
    class Tuple {
        TreeNode node;
        int row; 
        int col; 
        
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row; 
            int y = tuple.col;  
            
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).offer(node.data);
            
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            
            // Fix: Right child - column increases, level increases
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
       
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> currentList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    currentList.add(nodes.poll());
                }
            }
            result.add(currentList);
        }
        
        return result;
    }
}
