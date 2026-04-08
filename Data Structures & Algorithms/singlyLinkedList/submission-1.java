class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    
    ListNode head, tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = head;
    }

    public int get(int index) {
        ListNode current = head.next;
        int i = 0;
        while(current != null) {
            if (index == i) {
                return current.val;
            }
            i++;
            current = current.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i=0;
        ListNode current = this.head;
        while(i < index && current.next != null) {
            i++;
            current = current.next;
        }
        if (current != null && current.next != null) {
            if (current.next == this.tail) {
                this.tail = current;
            }
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode current = this.head.next;
        while(current != null) {
            values.add(current.val);
            current = current.next;
        }
        return values;
    }
}
