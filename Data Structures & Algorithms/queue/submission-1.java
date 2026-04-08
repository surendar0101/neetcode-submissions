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

    Node dummyHead;
    Node dummyTail;

    public Deque() {
        this.dummyHead = new Node(0);
        this.dummyTail = new Node(0);

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
        newNode.next = this.dummyHead.next;
        newNode.prev = this.dummyHead;
        this.dummyHead.next.prev = newNode;
        this.dummyHead.next = newNode;
    }

    public int pop() {
        if(this.isEmpty()) {
            return -1;
        }
        Node targetNode = this.dummyTail.prev;
        Node prevNope = targetNode.prev;
        this.dummyTail.prev = prevNope;
        prevNope.next = dummyTail;
        return targetNode.value;
    }

    public int popleft() {
        if(this.isEmpty()) {
            return -1;
        }
        Node targetNode = this.dummyHead.next;
        Node nextNode = targetNode.next;
        this.dummyHead.next = nextNode;
        nextNode.prev = this.dummyHead;
        return targetNode.value;
    }
}
