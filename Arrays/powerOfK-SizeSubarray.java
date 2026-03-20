class Solution {
    public int[] resultsArray(int[] nums, int k) {
    int n = nums.length;

        if(k == 1){
            return nums;
        }

        int result[] = new int[n - k + 1];

        // fill with -1
        for(int i = 0; i < result.length; i++){
            result[i] = -1;
        }

        int count = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1){
                count++;
            } else {
                count = 1;
            }

            if(count >= k){
                result[i - k + 1] = nums[i];
            }
        }

        return result;
    }
}
