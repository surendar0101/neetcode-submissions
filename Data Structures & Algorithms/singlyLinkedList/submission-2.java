class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {

    ListNode head, tail;
    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        int count = 0;
        ListNode current = this.head.next;
        while( current != null) {
            if (count == index)
                return current.value;
            count++;
            current = current.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val, this.head.next);
        this.head.next = newNode;
        if(head == tail) {
            this.tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int count = 0;
        ListNode current = head;
        while (count < index && current.next != null) {
            current = current.next;
            count++;
        }
        if(current != null && current.next != null) {
            if (current.next == this.tail) {
                this.tail = current;
            }
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ListNode current = head.next;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(current != null) {
            result.add(current.value);
            current = current.next;
        }
        return result;
    }
}
