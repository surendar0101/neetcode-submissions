class Node {
    int key, value;
    Node prev, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    private Node left, right;
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = this.right = new Node(-1, -1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) 
            remove(cache.get(key));
        
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (capacity < cache.size()) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        this.right.prev = prev.next = node;
        node.next = this.right;
        node.prev = prev;
    }

    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
