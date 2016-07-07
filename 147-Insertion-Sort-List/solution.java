/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        //Can not add this line here: dummy.next = head;
        ListNode cur = head;
        ListNode p = dummy;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            while ( p.next !=null && cur.val > p.next.val){
                p = p.next;
            }
            
            cur.next = p.next;
            p.next = cur;
            cur = next;
            p = dummy;
        }
        return dummy.next;
    }
}