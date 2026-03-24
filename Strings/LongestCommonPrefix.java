class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(strs==null || n==0)
            return "";
    //take first string as reference
    String first=strs[0];

    //Handle empty first string
    if (first.length() == 0) 
        return "";


    //go character by character 
    for(int i=0;i<first.length();i++){
        char ch=first.charAt(i);
        //check for the first & other string characters 
        for(int j=1;j<n;j++){
            if(strs[j].length()==0 || i>=strs[j].length() || strs[j].charAt(i)!=ch){
                return first.substring(0,i);
            }
        }
    }
    return first;
    }
}
