class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode temp=dummyNode;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next; 
            }
            else{
                temp=temp.next;
            }
            
        }
    return dummyNode.next;  
    }
}
