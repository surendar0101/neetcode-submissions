class Node {
    int value;
    Node next;
    Node prev;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class Deque {

    Node dummyHead, dummyTail;
    public Deque() {
        this.dummyHead = new Node(-1);
        this.dummyTail = new Node(-1);

        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public boolean isEmpty() {
        return this.dummyHead.next == this.dummyTail;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        newNode.prev = this.dummyTail.prev;
        newNode.next = this.dummyTail;
        this.dummyTail.prev.next = newNode;
        this.dummyTail.prev = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        newNode.prev = this.dummyHead;
        newNode.next = this.dummyHead.next;

        this.dummyHead.next.prev = newNode;
        this.dummyHead.next = newNode;
    }

    public int pop() {
        if (this.isEmpty()) {
            return -1;
        }
        Node targetNode = this.dummyTail.prev;
        Node prevNode = targetNode.prev;
        prevNode.next = this.dummyTail;
        this.dummyTail.prev = prevNode;
        return targetNode.value;
    }

    public int popleft() {
        if (this.isEmpty()) {
            return -1;
        }

        Node targetNode = this.dummyHead.next;
        Node nextNode = targetNode.next;
        nextNode.prev = this.dummyHead;
        this.dummyHead.next = nextNode;
        return targetNode.value;
    }
}
