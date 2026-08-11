class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String>q=new LinkedList<>();
        q.offer(beginWord);
        int cnt=1;
        HashSet<String>visited=new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(endWord)) return cnt;
                char[] arr=curr.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String newword=new String(arr);
                        if(!visited.contains(newword) && wordList.contains(newword)){
                            q.offer(newword);
                            visited.add(newword);
                        }
                    }
                    arr[j]=original;
                }
                
            }
            cnt++;
        }
        return 0;
    }
}
