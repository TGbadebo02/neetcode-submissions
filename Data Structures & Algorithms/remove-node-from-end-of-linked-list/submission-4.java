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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        ListNode prev = dummy;
        // -> 1 -> 2 -> 3 -> 4 -> null
        //.  hd    hd           cur
        while(n != 0) {
            n--;
            current = current.next;
        }

        while(current.next != null) {
            current = current.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        return dummy.next;
    }
}
