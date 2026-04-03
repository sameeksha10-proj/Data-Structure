Brute:
class Solution {

    ListNode Convert(ArrayList<Integer> arr){
        ListNode head=new ListNode(arr.get(0));
        ListNode temp=head;
        if(arr.size()==0)
            return head;
        for(int i=1;i<arr.size();i++){
            ListNode newNode=new ListNode(arr.get(i));
            temp.child=newNode;
            temp=temp.child;
        }
        return head;
    }

    public ListNode flattenLinkedList(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer> arr=new ArrayList<>();
        while(temp!=null){
            ListNode t2=temp;
            while(t2!=null){
                arr.add(t2.val);
                t2=t2.child;
            }
            temp=temp.next;
        }
        Collections.sort(arr);
        
    
    return Convert(arr);
    }
}
Optimal:
class Solution {
    ListNode merge(ListNode list1,ListNode list2){
        ListNode dummyNode=new ListNode(-1);
        ListNode res= dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val)
            {
                res.child=list1;
                res=list1;
                list1=list1.child;
            }
            else
            {
                res.child=list2;
                res=list2;
                list2=list2.child;
            }
            res.next=null;
        }
        if(list1!=null){
            res.child=list1;
        }
        else 
        {
            res.child=list2;
        }
        if(dummyNode.child!=null){
            dummyNode.child.next=null;
        }
    return dummyNode.child;
    }
    

    public ListNode flattenLinkedList(ListNode head) {

           if(head==null ||  head.next==null){
                return head;
           }     
           ListNode mergedhead=flattenLinkedList(head.next);

    return merge(head,mergedhead);
    }
}
