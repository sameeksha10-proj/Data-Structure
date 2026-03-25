class Solution {

    boolean isAlphanumeric(char ch){
        ch=Character.toLowerCase(ch);
        if((ch>='0' && ch<='9') || ch >='a'&& ch <='z'){
        return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int n=s.length();
        int start=0;
        int last=n-1;


        while(start<=last){
        if(!isAlphanumeric(s.charAt(start))){
            start++;
            continue;
        }
         if(!isAlphanumeric(s.charAt(last))){
            last--;
            continue;
        }
        if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))){
            return false;
        }
        start++;
        last--;
        }

    return true;
    }
}
