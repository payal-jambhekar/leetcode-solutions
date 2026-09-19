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
    public ListNode removeElements(ListNode head, int val) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            if (temp.val == val) {

                if (prev == null) {
                    // deleting the head
                    head = temp.next;
                } else {
                    // deleting a middle/end node
                    prev.next = temp.next;
                }

            } else {
                // move prev only when temp is NOT deleted
                prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}