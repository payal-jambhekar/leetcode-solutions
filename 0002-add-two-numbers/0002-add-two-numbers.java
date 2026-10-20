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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;

        while(head1 != null || head2 != null ||  carry != 0){
            
            int val1 = (head1 != null) ? head1.val :0;
            int val2 = (head2 != null) ? head2.val :0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode( digit);
            tail = tail.next;

            if(head1 != null){
                head1 = head1.next;
            }

            if(head2 != null){
                head2 = head2.next;
            }
        }
        return dummy.next;
    }
}