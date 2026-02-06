class reverseArray{
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6};
        int n[]=new int[arr.length];

        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            n[j]=arr[i];
            j++;
        }
        System.out.println("Reversed Array is:");
        for(int i=0;i<arr.length;i++){
            System.out.print(n[i]+" ");
        }
      
    }
}
