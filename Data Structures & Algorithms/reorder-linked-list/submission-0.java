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
        ListNode slow = head, fast = head.next;
        // Finding the mid to separate the list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = slow.next;
        // Initialize the end of both the lists to null
        // Since prev is going to hold the head of reversed second list
        ListNode prev = slow.next = null;
        while(secondList != null) {
            ListNode next = secondList.next;
            secondList.next = prev;
            prev = secondList;
            secondList = next;
        }

        ListNode firstList = head;
        secondList = prev;

        while (secondList != null) {
            ListNode temp1 = firstList.next;
            ListNode temp2 = secondList.next;
            firstList.next = secondList;
            secondList.next = temp1;
            firstList = temp1;
            secondList = temp2;
        }
    }
}
