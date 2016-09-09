/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head;
        int count = 0;
        while(p2 != null){
            p2 = p2.next;
            count++;
            if(count == k){
                p1 = reverse(p1, p2);
                count = 0;
            }
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode p = head.next, res = head.next;
        ListNode last = tail;
        while(p!=tail){
            ListNode temp = p.next;
            p.next = last;
            last = p;
            p = temp;
        }
        head.next = last;
        return res;
    }
}