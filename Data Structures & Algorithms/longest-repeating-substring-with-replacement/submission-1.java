class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int MaxFreq=0;
        int result=0;

        int left=0;
        
        HashMap<Character,Integer>map=new HashMap<>();
        
        for(int right=0;right<n;right++){
         char temp=s.charAt(right);
         map.put(temp,map.getOrDefault(temp,0)+1);
         MaxFreq=Math.max(MaxFreq,map.get(temp));

         while((right-left+1)-MaxFreq > k){
           char leftChar=s.charAt(left);
           map.put(leftChar,map.get(leftChar)-1);
           left++;
         }
         result=Math.max(result,right-left+1);
        }
        return result;   
    }
}
