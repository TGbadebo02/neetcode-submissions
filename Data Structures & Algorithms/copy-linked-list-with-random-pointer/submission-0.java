/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        //base case.
        if(head == null) return null;

        Map<Node,Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null);

        Node current = head;

        while(current != null){
            Node copy = new Node(current.val);
            oldToNew.put(current,copy);
            current = current.next;
        }

        current = head;

        while(current != null){
            Node copy = oldToNew.get(current);
            copy.next = oldToNew.get(current.next);
            copy.random = oldToNew.get(current.random);
            current = current.next;
        }

       return oldToNew.get(head);
    }
}
