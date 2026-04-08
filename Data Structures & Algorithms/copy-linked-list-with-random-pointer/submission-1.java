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

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mapToCopy = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            mapToCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = mapToCopy.get(curr);
            copy.next = mapToCopy.get(curr.next);
            copy.random = mapToCopy.get(curr.random);
            curr = curr.next;
        }
        return mapToCopy.get(head);
    }
}
