/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Using HashMap Two pass
class Solution {
    private Map<Node, Node> oldToCopy = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node curr = head;
        oldToCopy.put(null, null);

        // Pass one: creates nodes in hashmap
        while (curr != null) {
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        // Pass two: creates connection in hashmap
        while (curr != null) {
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }

        return oldToCopy.get(head);
    }
}
