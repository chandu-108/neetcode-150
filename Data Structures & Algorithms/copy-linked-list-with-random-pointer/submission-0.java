/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //Create the Same LinkedList
        Node curr=head;
        while(curr!=null){
            Node newnode=new Node(curr.val);
            newnode.next=curr.next;
            curr.next=newnode;
            curr=newnode.next;
        }
        //Now Assinging the random pointers
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        //Now Seperating the 2 Lists
        curr=head;
        Node newHead=head.next;
        Node newCurr=newHead;
        while(curr!=null){
            curr.next=newCurr.next;
            curr=curr.next;
            if(curr!=null){
                newCurr.next=curr.next;
                newCurr=newCurr.next;
            }
        }
        return newHead;
    }
}
