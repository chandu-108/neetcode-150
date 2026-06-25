class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        int len=strs.length;
        for(int i=0;i<len;i++){
            String s=strs[i];
             int freq[]=new int[26];
             //Take the freq 
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            // convert to the string (Key)
            StringBuilder st=new StringBuilder();
            for(int cnt:freq){
                st.append("#");
                st.append(cnt);
            }
            String key=st.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
    return new ArrayList<>(map.values());
    }
}
