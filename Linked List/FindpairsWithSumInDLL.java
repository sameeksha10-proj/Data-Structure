
//optimal 
class Solution {
    private ListNode findTail(ListNode head){
        ListNode tail=head;
        while(tail!=null && tail.next!=null){
            tail=tail.next;
        }
        return tail;
    }
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (head == null) return result;

        ListNode temp1=head;
        
        while(temp1!=null){

            int sum=left.val+right.val;
            if(sum == target){
                result.add(Arrays.asList(left.val,right.val));
                left=left.next;
                right=right.prev;
            }
            else  if(sum < target)
            {
                    left=left.next;
            }
            else {
                right=right.prev;
            }
        }
    return result;
    }
}
