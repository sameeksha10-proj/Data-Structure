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
