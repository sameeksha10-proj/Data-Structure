//bruteclass Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer>list=new ArrayList<>();
        int maxi=0;

        for(int i=0;i<=n-k;i++)
        {
            maxi=nums[i];

            for(int j=i;j<i+k;j++){
                maxi=Math.max(maxi,nums[j]);
        }
        list.add(maxi);
            
        } 
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
//optimal 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer>list=new ArrayList<>();
        Deque<Integer>dq=new ArrayDeque<>();

        for(int i=0;i<n;i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() <= i-k)
            {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            
        
            dq.addLast(i);

            if(i >= k-1)
                list.add(nums[dq.peekFirst()]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
