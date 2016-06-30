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
        ListNode fast = head;
        ListNode slow = pre;
        while (fast!= null){
            while (fast.next!= null && fast.next.val == fast.val){
                fast = fast.next;
            }
            if (slow.next==fast){
                slow = slow.next;
            } else slow.next = fast.next;
            fast = fast.next;
            }
        return pre.next;
    }
}