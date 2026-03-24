class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(strs==null || n==0)
            return "";
    //take first string as reference
    String first=strs[0];

    //go character by character 
    for(int i=0;i<n;i++){
        char ch=first.charAt(i);
        //check for the first & other string characters 
        for(int j=1;j<n;j++){
            if(i>=strs[i].length() || strs[j].charAt(i)!=ch){
                return first.substring(0,i);
            }
        }
    }
    return first;
    }
}
