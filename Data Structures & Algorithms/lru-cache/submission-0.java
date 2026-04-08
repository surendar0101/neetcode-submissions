// To implement a LRU cache - we need following
// 1) a doubly linked list - to stores recent elements
// 2) a hashMap - to store key values (val, add of number) - O(1) get and put

// Class for doubly linked list
class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}
class LRUCache {
    private final Map<Integer, Node> cache;
    private final Integer capacity;
    // The left maintains the LRU, the right maintains the MRU
    private Node left, right;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            this.removeNode(node);
            this.insertNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))
            this.removeNode(cache.get(key));
        
        this.cache.put(key, new Node(key, value));
        this.insertNode(cache.get(key));

        if (this.cache.size() > this.capacity) {
            Node lruNode = this.left.next;
            this.removeNode(lruNode);
            cache.remove(lruNode.key);
        }
    }

    // Helper functions
    // Removes the node and reassigns the connections
    private void removeNode(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Inserts the value towards the right
    private void insertNode(Node node) {
        Node prev = right.prev, next = right;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }
}
