Leaders in Array:
class Solution {
    public List<Integer> leaders(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(nums[i]>maxi){
                ans.add(nums[i]);
            }
            maxi=Math.max(maxi,nums[i]);
        }
    Collections.reverse(ans);

    return ans;
    }
}
