/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
        能解第二题必能解第一题。这题涉及两个部分：
        1. 检测linked list是否有环：用双指针追击法：
        快指针fast一次走两步，慢指针slow一次走一步。如果有环，两指针必定在某一时间相遇。fast不会跳过slow。因为如果fast跳过slow，那么前一步它们必已经相遇。
        2. 如果有环，如何判断环的起始点。
        假设linked list从head到环起始点s的长度为L，环的周长为C（两节点之间的长度为之间link的数量）
        当fast与slow第一次相遇的位置记为m1，并假设m1离开环起始点s距离X，由于fast走的总路程一定是slow的两倍：
        (L + X)*2 = L + n*C + X => L = n*C - X
        从m1出发，走n*C - X的路程将回到s，而这段路程正好等于head到s之间的路程！所以第一次相遇后，将slow移到head，然后slow/fast同时以一次走一步的速度前进，直到它们第二次相遇，便是s了。
        */
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast == null || fast.next == null ) return null;
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);
        
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}