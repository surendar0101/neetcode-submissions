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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i=0; i < lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(mergeList(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode dummyHead = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummyHead.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                dummyHead.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummyHead = dummyHead.next;
        }

        while (list1 != null) {
            dummyHead.next = new ListNode(list1.val);
            dummyHead = dummyHead.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            dummyHead.next = new ListNode(list2.val);
            dummyHead = dummyHead.next;
            list2 = list2.next;
        }

        return dummyNode.next;
    }
}
