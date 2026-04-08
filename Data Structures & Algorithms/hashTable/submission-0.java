// Singly linked List node
class Node {
    int key;
    int value;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable {
    private int capacity;
    private int size;
    private Node[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Node[this.capacity];
    }

    private int hashFunction(int key) {
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = this.hashFunction(key);
        // Check if the node is present in the table or not
        Node node = this.table[index];
        if (node == null) {
            // if the node is not present in the table 
            // add node to table in 'index'
            this.table[index] = new Node(key, value);
            this.size++;
        } else {
            Node prev = null;
            while(node != null) {
                if (node.key == key) {
                    // If node already present update value
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size++;
        }
        if ((double) this.size / this.capacity >= 0.5) {
            this.resize();
        }
    }

    public int get(int key) {
        int index = this.hashFunction(key);
        Node node = this.table[index];
        while (node != null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = this.hashFunction(key);
        Node removeNode = this.table[index];
        Node prev = null;
        while(removeNode != null) {
            
            if (removeNode.key == key) {
                if (prev != null) {
                    // remove the node from linked list
                    prev.next = removeNode.next;
                } else {
                    // in first iteration
                    // update the index to
                    // delete node's next index
                    this.table[index] = removeNode.next;
                }
                this.size--;
                return true;
            }
            prev = removeNode;
            removeNode = removeNode.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        // Update the capacity of hash table by doubling the size
        int newCapacity = this.capacity * 2;
        Node[] newTable = new Node[newCapacity];
        for(Node node: table) {
            while(node != null) {
                // re-calculate the index and place in new position
                int index = node.key % newCapacity;
                if (newTable[index] == null) {
                    newTable[index] = new Node(node.key, node.value);
                } else {
                    // if newTable already have value in index
                    // find for next available index 
                    // and place new value
                    Node newNode = newTable[index];
                    while(newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }
}
