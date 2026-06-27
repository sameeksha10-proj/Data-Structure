class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int a = nums[i];
            int move = target - a;
            if(map.containsKey(move))
            {
                return new int[]{map.get(move),i};
            }
            map.put(a,i);
        }
     return new int[]{-1,-1};
    }
}


class Solution {
    
    private boolean binarySearch(int[] arr,int left,int right,int target)
    {
        int n=arr.length;
        left=0;
        right=n-1;
        while(left < right)
        {
            int mid=((left+right)/2);
            if(arr[mid]==target)
            {
                return true;
            }
            if(arr[mid] < target)
            {
                left=mid+1;
            }
            else 
            {
                right=mid-1;
            }
        }
           return false;
    }
    //using sorting
    boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int a=arr[i];
            int more= target - a;
            
            if(binarySearch(arr,i+1,n-1,more))
            {
                return true;
            }
        }
        return false;
        
    }
}
