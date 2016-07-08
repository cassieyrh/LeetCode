/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head.next.next;
        while(f!= null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        ListNode head2 = sortList(s.next);
        s.next = null;
        return merge(sortList(head), head2);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (head1 != null && head2 != null){
            if (head1.val > head2.val){
                cur.next = head2;
                head2 = head2.next;
            }else{
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = head1 ==null? head2:head1;
        return pre.next;
    }
}