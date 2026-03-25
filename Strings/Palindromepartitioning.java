class Solution {
void getAllParts(int start,String s, List<List<String>> ans, List<String> partition){
        int n=s.length();
            if(start==n){
                ans.add(new ArrayList<>(partition));
                return;
            }
            for(int i=start;i<n;i++){
                String part=s.substring(start,i+1);
              if (isPalin(part)) {
                partition.add(part);                      // choose
                getAllParts(i + 1, s, ans, partition);   // explore
                partition.remove(partition.size() - 1);  // backtrack
            }
            }   
    }
    boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) 
            return false;
            l++;
            r--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
    List<List<String>> ans=new ArrayList<>();
    List<String> partition=new ArrayList<>();
    getAllParts(0,s,ans,partition);

    return ans;

    }
}
