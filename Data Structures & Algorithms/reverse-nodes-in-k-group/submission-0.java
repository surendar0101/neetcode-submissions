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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode groupPrev = dummyNode;
        while(true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null)
                break;
            
            ListNode groupNext = kth.next;
            
            // Revert the group
            ListNode prev = kth.next, curr = groupPrev.next;
            while(curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode next = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = next;

        }
        return dummyNode.next;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
