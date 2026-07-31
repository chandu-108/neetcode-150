class Solution {

    public String encode(List<String> strs) {
    StringBuilder st=new StringBuilder();
    for(String s:strs){
        st.append(s.length());
        st.append("#");
        st.append(s);
    }
    return st.toString();
    }

    public List<String> decode(String str) {
    int n=str.length();
    ArrayList<String>result=new ArrayList<>();
    int i=0;
    while(i<n){
        int j=i;
        while(str.charAt(j)!='#'){
            j++;
        }
        int len=Integer.parseInt(str.substring(i,j));
        j++;
        result.add(str.substring(j,j+len));
        i=j+len;
    }
    return result;
    }
}
