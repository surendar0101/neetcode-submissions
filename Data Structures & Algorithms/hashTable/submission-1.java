class Node {
    int key, value;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {

    private int capacity;
    private int size;
    private Node[] hashTable;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hashTable = new Node[this.capacity];
    }

    private int hashFunction(int key) {
        // gets index based on reminder from key and capacity
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = this.hashFunction(key);
        Node node = this.hashTable[index];

        if (node == null) {
            // if no node is present in index,
            // then add node to hash table
            this.hashTable[index] = new Node(key, value);
        } else {
            // if node is already present in the index,
            // then search for next available position
            Node prev = null;
            while(node != null) {
                if (node.key == key) {
                    // if key already exists then update the value
                    // but hashmap of java throws an error 
                    // if key already exists
                    node.value = value;
                    return;
                }
                prev = node; // update prev to current node
                node = node.next; // fast forward node till end
            }
            prev.next = new Node(key, value);
        }
        size++;
        // check if the size is less than half the capacity
        // once the map is half full then re-hash the map
        if ((double) this.size / this.capacity >= 0.5) {
            this.resize();
        }
    }

    public int get(int key) {
        int index = this.hashFunction(key);
        Node searchNode = this.hashTable[index];
        while (searchNode != null) {
            if (searchNode.key == key) {
                return searchNode.value;
            }
            searchNode = searchNode.next;
        }
        return -1; // if key not found then return -1
    }

    public boolean remove(int key) {
        int index = this.hashFunction(key);
        Node node = this.hashTable[index];
        // stores the prev of current node to delete the key at index
        Node prev = null; 
        while(node != null) {
            // iterate till current node with key is found
            if (node.key == key) {
                if (prev == null) {
                    // if node to be deleted is in first index
                    // then point the index location to next node
                    this.hashTable[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false; // return false if no node found for 'key'
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int newCapacity = this.capacity * 2;
        Node[] newHashTable = new Node[newCapacity];
        for (Node node: hashTable) {
            while(node != null) {
                int index = node.key % newCapacity;
                Node newNode = newHashTable[index];
                if (newNode == null){
                    // add new node to 'index' if no node present
                    newHashTable[index] = new Node(node.key, node.value);
                } else {
                    // if a node is already present in index,
                    // then find for next available index
                    // iterate till new node's next position is not null
                    while(newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.value);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.hashTable = newHashTable;
    }
}
