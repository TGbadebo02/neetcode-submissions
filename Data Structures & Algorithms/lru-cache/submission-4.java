class Node {
    Node next;
    Node prev;
    int val;
    int key;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        prev = null;
        next = null;
    }
}
class LRUCache {
    // WORNG PLACE OF INITLIZING.
    // private HashMap<Integer, Node> cache = new HashMap<>();
    private HashMap<Integer, Node> cache = new HashMap<>();
    private int cap;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // key arent inserted because its inside the if statment check.
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        add(newNode);

        if (cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public void add(Node node) {
        Node next = right;
        Node prev = right.prev;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }
}
