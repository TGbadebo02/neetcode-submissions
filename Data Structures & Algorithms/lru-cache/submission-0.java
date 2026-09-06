class DoublyLinkedList {
    int val;
    int key;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    public DoublyLinkedList(int key, int val) {
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private Map<Integer, DoublyLinkedList> cache;
    private DoublyLinkedList first;
    private DoublyLinkedList second;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        //map the key -> nodes.
        this.cache = new HashMap<>();
        //nodes tell use most recent and least recent.
        //first is lRU and second is MRU.
        this.first = new DoublyLinkedList(0,0);
        this.second = new DoublyLinkedList(0,0);

        this.first.next = this.second;
        this.second.prev = this.first;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //have to reset it as the recently used in the cache.
            DoublyLinkedList node = cache.get(key);
            //remove it from its current position.
            removeNode(node);
            //add it to the end of the linked list.
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            //if it already exists remove it.
            cache.remove(cache.get(key));
        }
        DoublyLinkedList newNode = new DoublyLinkedList(key, value);
        cache.put(key, newNode);
        addNode(newNode);
        //if cache exceeds the capacity.
        if(cache.size() > cap){
            //remove the the least recent node.
            DoublyLinkedList lru = this.first.next;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    public void addNode(DoublyLinkedList node){
        //position the pointers.
        DoublyLinkedList prev = this.second.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.second;
        this.second.prev = node;
       
    }

    public void removeNode(DoublyLinkedList node){
        
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList nextNode = node.next;
        prev.next = nextNode;
        nextNode.prev = prev;
    }
}
