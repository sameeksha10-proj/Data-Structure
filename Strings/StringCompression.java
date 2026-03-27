class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int index=0;
        int i=0;

        while(i<n){
            char curr_char=chars[i];
            int count=0;

        //Find count of Duplicates
        while(i<n && chars[i]==curr_char){
            count++;
            i++;
        }
        chars[index]=curr_char;
        index++;

        //Assigning work of count and char to  index
        if(count>1){
            String count_str = String.valueOf(count);
            for(char ch:count_str.toCharArray()){
                chars[index]=ch;
                index++;
            }

        }
        }
    return index;
    }
}
