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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode dummyHead = dummyNode;
        while(list1 != null && list2 != null ) {
            if (list1.val < list2.val) {
                dummyNode.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                dummyNode.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            dummyNode = dummyNode.next;
        }

        while(list1 != null) {
            dummyNode.next = new ListNode(list1.val, null);
            dummyNode = dummyNode.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            dummyNode.next = new ListNode(list2.val, null);
            dummyNode = dummyNode.next;
            list2 = list2.next;
        }
        return dummyHead.next;
    }
}