class Solution {
    public int secondLargestElement(int[] nums) {
    
    int largest=nums[0];
    int slargest=-1;

    for(int i=1;i<nums.length;i++){
        if(nums[i]>largest){
            slargest=largest;
            largest=nums[i];
        }
        else if(nums[i]<largest && nums[i]>slargest){
            slargest=nums[i];
        }
    }
    return slargest;
    }
}


// Harshad : what if the data given is negative : {-10, -9, -8, -7}
Enter size for an array : 
4
-10
-9
-8
-7
Second large element is : -8
