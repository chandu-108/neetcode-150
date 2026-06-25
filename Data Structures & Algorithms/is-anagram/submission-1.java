class Solution {
    public boolean isAnagram(String s, String t) {
        char ch1[]=s.toCharArray();
        char ch2[]=t.toCharArray();
      
        Arrays.sort(ch1);
        Arrays.sort(ch2);
         
        int n=ch1.length;
        int m=ch2.length;

        if(n!=m)  return false;
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }
    return true;
    }
}
