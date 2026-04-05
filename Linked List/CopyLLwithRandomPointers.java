/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    void insertCopyInBetween(Node head){
        Node temp=head;
        while (temp!=null){
            Node CopyNode=new Node(temp.val);
            CopyNode.next=temp.next;
            temp.next=CopyNode;
            temp=temp.next.next;
        }
    } 
    void connectRandomPointers(Node head){
        Node temp=head;
        while(temp!=null){
            Node CopyNode=temp.next;
            if(temp.random!=null){
                CopyNode.random=temp.random.next;
            }
            else 
            {
                CopyNode.random=null;
            }
            temp=temp.next.next;
        }
    }
    private Node getDeepCopyList(Node head){
        Node dNode=new Node(-1);
        Node res=dNode;
        Node temp=head;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;

            temp.next=temp.next.next;
            temp=temp.next;
        }
    return dNode.next;
    }
    public Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
}
