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
    private final Map<Integer, Node> cache;
    private final int capacity;
    private Node left, right;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = this.right = new Node(-1,-1); // Dummynodes denoting limits
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = cache.get(key);
            this.removeNode(node);
            this.insertNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))
            this.removeNode(cache.get(key));
        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        this.insertNode(cache.get(key));

        if (this.cache.size() > capacity) {
            Node lruNode = this.left.next;
            this.removeNode(lruNode);
            cache.remove(lruNode.key);
        }
    }

    // Helper methods
    private void removeNode(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNode(Node node) {
        Node prev = right.prev, next = right;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }
}
