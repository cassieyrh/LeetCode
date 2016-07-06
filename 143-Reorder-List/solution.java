/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null|| head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null){
            if (fast.next == null) {
                fast = fast.next;
                slow = slow.next;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
                
        }
        ListNode second = reverse(slow);
        ListNode first = head;
        while (second != null){
            ListNode temp1 = first.next;
            first.next = second;
            ListNode temp2 = second.next;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        first.next = null;
    }
    
    private ListNode reverse(ListNode node){
        if (node == null) return node;
        ListNode pre = node;
        ListNode cur = node.next;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        node.next = null;
        return pre;
    }
}