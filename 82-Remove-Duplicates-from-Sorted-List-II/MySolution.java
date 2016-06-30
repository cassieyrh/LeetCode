/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-100);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (fast.next != null){
            while (fast.next!= null && fast.next.val == fast.val){
                fast = fast.next;
            }
            if (fast.next == null){
                slow.next = null; return pre.next;
            } else fast = fast.next;
            if (fast.next != null && fast.next.val == fast.val) continue;
            slow.next = fast;
            slow = slow.next;
            }
        return pre.next;
    }
}