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
        mapToCopy.put(null, null);
        Node curr = head;
        while (curr != null) {
            if (!mapToCopy.containsKey(curr)) {
                mapToCopy.put(curr, new Node(0));
            }
            mapToCopy.get(curr).val = curr.val;

            if (!mapToCopy.containsKey(curr.next)) {
                mapToCopy.put(curr.next, new Node(0));
            }
            mapToCopy.get(curr).next = mapToCopy.get(curr.next);

            if (!mapToCopy.containsKey(curr.random)) {
                mapToCopy.put(curr.random, new Node(0));
            }
            mapToCopy.get(curr).random = mapToCopy.get(curr.random);
            curr = curr.next;
        }
        return mapToCopy.get(head);
    }
}
