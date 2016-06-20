/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        int sum=0;
        int carry = 0;
        
        while (l1 != null || l2 != null){
            int a = 0,b = 0;
            if (l1 != null){
                 a = l1.val;
            }
            if (l2 != null){
                 b = l2.val;
            }
            sum = a + b + carry;
            if (sum >9){
                sum -= 10;
                carry = 1;
            }else carry =0;
            p.next = new ListNode(sum);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) p.next = new ListNode(1);
        return pre.next;
    }
}