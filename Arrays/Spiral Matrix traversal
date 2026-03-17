class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int left=0;
        int right=m-1;
        int top=0;
        int bottom=n-1;
        
        while(top<=bottom && left<=right){
            
        //left->right
        for(int i=left;i<=right;i++){
            ans.add(matrix[top][i]);
        }
        top++;
        //top->bottom
        for(int i=top;i<=bottom;i++){
            ans.add(matrix[i][right]);
        }
        right--;

        //right->left
        if(top<=bottom){        
        for(int i=right;i>=left;i--){
            ans.add(matrix[bottom][i]);
        }
        bottom--;
        }
        if(left<=right){

        //bottom->top
        for(int i=bottom;i>=top;i--){
            ans.add(matrix[i][left]);
        }
        left++;
        }

    }
    return ans;
}
}
