
 class Solution {
    private static int LengthofLoop(ListNode slow,ListNode fast){
        int cnt=1;
        fast=fast.next;
        while(slow!=fast){
            cnt++;
            fast=fast.next;
        }
        return cnt;
    }
    public int findLengthOfLoop(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return LengthofLoop(slow,fast);
        }
        return 0;
     }
 }
