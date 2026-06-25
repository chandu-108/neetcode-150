class Solution {
    public int lengthOfLongestSubstring(String s) {
       //Sliding Window Problem
       int left=0;
       int maxi=0;

       HashSet<Character>set=new HashSet<>();   
        int n=s.length();
        for(int right=0;right<n;right++){
        while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxi=Math.max(maxi,right-left+1);
       }
       return maxi;
    }
}
