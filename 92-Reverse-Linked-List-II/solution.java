/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i< m-1; i++){
            slow = slow.next;
        }
        ListNode temp1 = slow;
        slow = slow.next;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        ListNode temp2 = fast.next;
        ListNode p = slow.next;
        slow.next = temp2;
        while(p != temp2){
            ListNode tmp = p.next;
            p.next = slow;
            slow = p;
            p = tmp;
        }
        temp1.next = slow;
        return dummy.next;
    }
}