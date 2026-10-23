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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        ListNode prev = slow.next = null;
        
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        ListNode first = head;
        cur = prev;

        while(cur != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = cur.next;
            first.next = cur;
            cur.next = tmp1;
            first = tmp1;
            cur = tmp2;
        }
    }
}
