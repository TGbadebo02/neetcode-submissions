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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        for (ListNode node : lists) {
            ListNode current = node;

            while (current != null) {
                list.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(list);
        
        ListNode dummy = new ListNode();
        ListNode resultNode = dummy;

        for (int val : list) {
            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }

        return dummy.next;
    }
}
