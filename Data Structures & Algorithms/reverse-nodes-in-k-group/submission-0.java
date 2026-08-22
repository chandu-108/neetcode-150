/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode curr=dummy,prev=dummy;
        int cnt=0;
        while(curr.next!=null){
            curr=curr.next;
            cnt++;
        }
        curr=head;
        while(cnt>=k){
            ListNode next=curr.next;

            for(int i=1;i<k;i++){
               curr.next=next.next;
               next.next=prev.next;
               prev.next=next;
               next=curr.next;
            }
            prev=curr;
            curr=curr.next;
            cnt-=k;
        }

    return dummy.next;
    }
}
