class Solution {
    public int characterReplacement(String s, int k) {
     int n=s.length();
     int left=0;
     int result=0;
     int maxfreq=0;
     HashMap<Character,Integer>map=new HashMap<>();
     for(int right=0;right<n;right++){
        char temp=s.charAt(right);
        map.put(temp,map.getOrDefault(temp,0)+1);
        maxfreq=Math.max(maxfreq,map.get(temp));
        //Main Intution Where I was stuck
        while((right-left+1)-maxfreq>k){
        char leftChar=s.charAt(left);
        map.put(leftChar,map.get(leftChar)-1);
        left++;
        }
      result=Math.max(result,right-left+1);
     }
     return result;
    }
}
