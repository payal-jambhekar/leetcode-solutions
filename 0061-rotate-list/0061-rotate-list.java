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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        int len =1;
       
        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        k = k % len;
        curr.next = head;

        int steps =  len - k;

        ListNode newTail = head;

        for(int i=1; i< steps ; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}