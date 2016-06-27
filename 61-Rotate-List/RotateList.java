/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //k might be greater than the total length of the linked list;
        if(head == null || k == 0 || head.next == null) return head;
        int len = 1;
        ListNode p = head;
        ListNode p1 = head;
        while (p.next != null){
            p = p.next;
            len++;
        }
        if (k%len == 0) return head;
        int m = len - k%len;
        for (int i = 0; i < m-1; i++){
            p1 = p1.next;
        }
        
        ListNode temp = p1.next;
        p1.next = null;
        p.next = head;
        head = temp;
        return head;
        
    }
}