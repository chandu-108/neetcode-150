class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer>map=new HashMap<>();
        int n=words.length;
        int len=order.length();
        //Priority Wise Stroing Completed
        for(int i=0;i<len;i++){
          map.put(order.charAt(i),i);
        }
        //Iterating the loop and comparsion
        for(int i=0;i<n-1;i++){
            String temp1=words[i];
            String temp2=words[i+1];

            int j=0;

            while(j<temp1.length()  && j<temp2.length()){
                char ch1=temp1.charAt(j);
                char ch2=temp2.charAt(j);

                if(ch1==ch2){
                    j++;
                    continue;
                }

                if(map.get(ch1) > map.get(ch2)){
                    return false;
                }
                break;
            }
            if(j==temp2.length() && temp1.length() > temp2.length()){
                return false;
            }
        }  
        return true;
    }
}