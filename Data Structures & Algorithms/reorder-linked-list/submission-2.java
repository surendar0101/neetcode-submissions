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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = head;
        ListNode newListCurr = reverseLinkedList(slow.next);
        slow.next = null;
        while(newListCurr != null ) {
            ListNode temp1 = curr.next;
            ListNode temp2 = newListCurr.next;
            curr.next = newListCurr;
            newListCurr.next = temp1;
            curr = temp1;
            newListCurr = temp2;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
