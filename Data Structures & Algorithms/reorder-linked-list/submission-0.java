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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //Step-1 Finding the Middle Element
        ListNode slow=head;
        ListNode fast=head;
         
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //Dividing the LinkedList based on the Slow pointer
        ListNode second=slow.next;
        slow.next=null;
        //step-2 reversing the divided LinkedList
        ListNode prev=null;
        while(second!=null){
            ListNode next=second.next;
            second.next=prev;
            prev=second;
            second=next;
        }
        //step-3 Merge the two LinkedList
        ListNode first=head;
        ListNode third=prev;
        while(third!=null){
            ListNode temp1=first.next;
            ListNode temp2=third.next;

            first.next=third;
            third.next=temp1;

            first=temp1;
            third=temp2;
        }
    }
}
