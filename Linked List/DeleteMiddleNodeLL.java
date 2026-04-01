//Brute force
public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        int res=(n/2);
        temp=head;
        while(temp!=null){
            res--;
            if(res==0){
                ListNode middle=temp.next;
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    return head;
    }
//using tortoise & Hare algorithm
class Solution {
    public ListNode deleteMiddle(ListNode head) {
    if(head==null || head.next==null)
        return null;
    ListNode slow=head;
    ListNode fast=head;
    fast=fast.next.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
      
       slow.next=slow.next.next;

    return head;
    }
}
