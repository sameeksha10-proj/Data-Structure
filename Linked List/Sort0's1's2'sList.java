//Brute 
class Solution {
    public ListNode sortList(ListNode head) {
      ListNode temp=head;
      int cnt0=0,cnt1=0,cnt2=0;

      while(temp!=null){
        if(temp.data==0)
        {
            cnt0++;
        }
        else  if(temp.data==1)
        {
            cnt1++;
        }
        else
        {
            cnt2++;
        }
        temp=temp.next;
    }
    temp=head;
    while(temp!=null){
        if(cnt0!=0)
        {
            temp.data=0;
            cnt0--;
        }
        else  if(cnt1!=0)
        {
            temp.data=1;
            cnt1--;
        }
        else
        {
            temp.data=2;
            cnt2--;
        }
        temp=temp.next;
      }

    return head;  
}
}
//optimal 
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode zeroHead=new ListNode(-1);
        ListNode oneHead=new ListNode(-1);
        ListNode twoHead=new ListNode(-1);

        ListNode zero=zeroHead;
        ListNode one=oneHead;
        ListNode two=twoHead;
        ListNode temp=head;

        while(temp!=null){
            if(temp.data == 0) 
            {
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data == 1)
            {
                one.next=temp;
                one=one.next;
            }
            else 
            {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
    zero.next=(oneHead.next!=null) ? (oneHead.next) : (twoHead.next);
    one.next=twoHead.next;
    two.next=null;

    ListNode newHead=zeroHead.next;

    return newHead;
    }
}
