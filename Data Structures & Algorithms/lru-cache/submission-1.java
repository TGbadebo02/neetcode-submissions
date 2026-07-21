class Node{
    int val;
    int key;
    Node prev;
    Node next;
    
    //need a double linked list bcuz....I need to keep adding the node
    //in a given place.
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    HashMap<Integer,Node> cache;
    int cap; 
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.cache = new HashMap<>();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            //first remove from the list.
            Node node = cache.get(key);
            remove(node);
            insert(node);
            //then insert to the list.
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
           remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);

        if(cache.size() > cap){
            //the logic to remove LRU;
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }


    public void insert(Node node){
        Node next = right;
        Node prev = right.prev;
        next.prev = node;
        prev.next = node;
        node.next = next;
        node.prev = prev;
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
}
