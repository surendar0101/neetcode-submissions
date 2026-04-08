class Node {
    int key, value;
    Node prev , next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}
class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = this.right = new Node(-1,-1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))
            remove(cache.get(key));
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            Node lruNode = this.left.next;
            remove(lruNode);
            cache.remove(lruNode.key);
        }
    }

    private void insert(Node node) {
        Node prev = right.prev, next = right;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
