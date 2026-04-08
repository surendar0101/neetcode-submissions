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
    public boolean hasCycle(ListNode head) {
        if (head == null) 
            return false;
        ListNode slow = head, fast = head.next;
        boolean result = false;
        while(fast != null && fast.next != null) {
            if (slow == fast) {
                result = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;
    }
}
