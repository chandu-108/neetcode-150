class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int len1=s1.length();
    int len2=s2.length();
    
    HashMap<Character,Integer>map1=new HashMap<>();
    HashMap<Character,Integer>map2=new HashMap<>();

    for(char c:s1.toCharArray()){
        map1.put(c,map1.getOrDefault(c,0)+1);
    }
    int left=0;
    int right=0;
    while(right < len2){

    char c = s2.charAt(right);
    map2.put(c, map2.getOrDefault(c, 0) + 1);

    // Shrink if window is too large
    if(right - left + 1 > len1){

        char leftChar = s2.charAt(left);

        map2.put(leftChar, map2.get(leftChar) - 1);

        if(map2.get(leftChar) == 0){
            map2.remove(leftChar);
        }

        left++;
    }

    // Compare when window size is exactly len1
    if(right - left + 1 == len1){
        if(map1.equals(map2)){
            return true;
        }
    }

    right++;
}
return false;
    }
}