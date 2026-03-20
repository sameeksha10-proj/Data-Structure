class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        String ans="";

        // 1. Reverse full string
        String reversed = new StringBuilder(s).reverse().toString();

        for(int i=0;i<n;i++){
            String word=""; 

            while(i<n && reversed.charAt(i)!=' '){
                word+=reversed.charAt(i);
                i++;
            }
             // 1. Reverse full string
        String reWord= new StringBuilder(word).reverse().toString();

        if(word.length()>0){
            ans+=" "+reWord;
        } 
        }
    return ans.substring(1);
    }
}
