/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = head;
        ListNode p = pre;
        while (fast!=null){
            if(fast.val >= x) {
                fast = fast.next; p = p.next;
                
            }else {
                if(slow.next == fast) {
                    slow = slow.next;
                    fast = fast.next;
                    p = p.next;
                }else{
                    ListNode temp = slow.next; 
                    ListNode temp2 = fast.next;
                    slow.next = fast;
                    fast.next = temp;
                    slow = slow.next;
                    p.next = temp2;
                    fast = temp2;
                    
                }
            }
        }
        return pre.next;
    }
}