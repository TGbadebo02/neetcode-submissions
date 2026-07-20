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
        if(head == null) return null;

        HashMap<Node,Node> nodeMap = new HashMap<>();
        nodeMap.put(null,null);
        Node current = head;

        while(current != null){
            Node newNode = new Node(current.val);
            nodeMap.put(current, newNode);
            current = current.next;
        }

        current = head; 

        while(current != null){
            Node newNode = nodeMap.get(current);
            newNode.next = nodeMap.get(current.next);
            newNode.random = nodeMap.get(current.random);
            current = current.next;
        }

        return nodeMap.get(head);
    }
}
