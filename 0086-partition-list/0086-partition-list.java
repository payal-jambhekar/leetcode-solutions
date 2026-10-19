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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) return head;

        ListNode dummyA = new ListNode(0);
        ListNode dummyB = new ListNode(0);

        ListNode small = dummyA;
        ListNode large = dummyB;

        ListNode curr = head;

        while(curr != null){

            if(curr.val < x){
                small.next = curr;
                small = curr;
                curr =curr.next;
            }else{
                large.next = curr;
                large = curr;
                curr =curr.next;
            }

        }

        large.next = null;
        small.next = dummyB.next;

        return dummyA.next;
    }
}