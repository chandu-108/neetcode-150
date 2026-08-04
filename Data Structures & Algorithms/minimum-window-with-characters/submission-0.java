class Solution {
    public String minWindow(String s, String t) {
        int[] mapS=new int[256];
        int[] mapT=new int[256];
        
        for(char ch:t.toCharArray()){
            mapT[ch]++;
        } 
        int right=0,min=Integer.MAX_VALUE;
        String result="";

        for(int i=0;i<s.length();i++){
            while( right < s.length() && !isDesirable(mapS,mapT)){
                 mapS[s.charAt(right)]++;

                 right++;

        }

        if(isDesirable(mapS,mapT) && min > right-i+1){
            result=s.substring(i,right);
            min=right-i+1;
        }
        mapS[s.charAt(i)]--;
    }
    return result;
}
private boolean isDesirable(int[] mapS,int[] mapT){
    for(int i=0;i<mapT.length;i++){
        if(mapT[i] > mapS[i]){
            return false;
        }
    }
    return true;
}
}
