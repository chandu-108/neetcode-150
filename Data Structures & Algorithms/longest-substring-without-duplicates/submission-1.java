class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxi=0;
        int n=s.length();
        int left=0;
        HashSet<Character>set=new HashSet<>();
        for(int right=0;right<n;right++){
            
           while(!set.isEmpty() && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
           set.add(s.charAt(right));
           maxi=Math.max(maxi,right-left+1);
        }
        return maxi;
    }
}
