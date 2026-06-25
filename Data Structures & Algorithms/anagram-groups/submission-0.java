class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        int len=strs.length;
        for(int i=0;i<len;i++){
            String s=strs[i];
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
    return new ArrayList<>(map.values());
    }
}
