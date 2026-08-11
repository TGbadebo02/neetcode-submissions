/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
       return dfs(node);
    }

    public Node dfs(Node node){// it should be a node type return.
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);
        
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);

        for(Node ngbhr : node.neighbors){
           // Node newNghbr = new Node(ngbhr.val);
           // map.get(ngbhr).neighbors.add(newNghbr);
           // dfs(ngbr);
           //CORRECT INTUITION.
           copyNode.neighbors.add(dfs(ngbhr));
        }
        
        return copyNode;
    }
}