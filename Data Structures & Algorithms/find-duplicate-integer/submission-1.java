class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length > 10000)
            return 0;

        Arrays.sort(nums);
        ListNode dummy = new ListNode(0, null);
        ListNode current = dummy;

        for (int num : nums) {
            if (current.val == num) {
                return num;
            }

            current.next = new ListNode(num, null);
            current = current.next;
        }

        return 0;
    }
}
