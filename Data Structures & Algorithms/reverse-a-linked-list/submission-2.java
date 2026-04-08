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
    public ListNode reverseList(ListNode head) {
        // If head is null or having only one node return head
        if(head == null || head.next == null) return head;

        ListNode current = head, prev = null;
        while(current != null) {
            // preserve the current pointer's next element
            ListNode next = current.next;

            // reverse the connection of current's next pointer to prev pointer
            current.next = prev;

            // make the prev pointer point to current pointer
            prev = current;

            // move forward with current pointer's preserved next
            current = next;
        }
        return prev;
    }
}
