class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<String>stringst=new Stack<>();
Stack<Integer>numst=new Stack<>();
int cnt=0;
String current="";
for(char ch:s.toCharArray()){
    //Number
    if(Character.isDigit(ch)){
    cnt=cnt*10+(ch-'0');
    }

    // [
else if(ch=='['){
    numst.push(cnt);
    cnt=0;
    stringst.push(current );
     current="";
}
   // ]

else if(ch==']'){
    int repeat=numst.pop();
    String prev=stringst.pop();
     String temp="";
    for(int k=0;k<repeat;k++){
        temp+=current;
    }
    current=prev+temp;
}
else{
    current+=ch;
    }
}
    return current;
}
}