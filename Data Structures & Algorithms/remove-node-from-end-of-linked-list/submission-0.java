/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode left = dummyNode, right = head;

        // Space the right pointer at an offset of n
        while( n > 0 ) {
            right = right.next;
            n--;
        }

        // place the left pointer before n'th index
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // delete the n'th node
        left.next = left.next.next;

        return dummyNode.next;
    }
}
