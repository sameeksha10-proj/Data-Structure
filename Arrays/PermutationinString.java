class Solution {
    boolean isFrequencySame(int freq1[],int freq2[]){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int frequency[]=new int[26];
        for(int i=0;i<s1.length();i++){
            frequency[s1.charAt(i) - 'a']++;;         
        }
        int windSize=s1.length();
        for(int i=0;i<s2.length();i++){
            int windIndex=0;
            int Index=i;
            int windFrequency[]=new int[26];

            while(windIndex < windSize && Index<s2.length()){
                windFrequency[s2.charAt(Index) - 'a']++;
                windIndex++;
                Index++;
            }
        if(isFrequencySame(frequency,windFrequency)){
            return true;
        }
        }
    return false;
    }
}
