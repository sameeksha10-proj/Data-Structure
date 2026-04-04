/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class NodePair {
        int val;
        ListNode node;
        
        NodePair(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) return null;

        PriorityQueue<NodePair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(new NodePair(lists[i].val,lists[i]));
        }

        ListNode dummyNode=new ListNode(-1);
        ListNode temp= dummyNode;

        while(!pq.isEmpty()){
            NodePair p=pq.poll();
        if(p.node.next!=null){
            pq.add(new NodePair(p.node.next.val,p.node.next));
        }
        temp.next=p.node;
        temp=temp.next;
        }
    return dummyNode.next;
        }
    }
