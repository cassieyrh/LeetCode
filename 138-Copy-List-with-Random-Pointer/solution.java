/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        RandomListNode p = dummy, pp = dummy, newNode, randomNode;
        while(head != null){
            newNode = new RandomListNode(head.label);
            RandomListNode temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            head = temp;
        }
        p = p.next;
        while(p != null){
            if(p.random != null) {
                randomNode = p.random; //do not forget the condition
                p.next.random = randomNode.next;
            }
            p = p.next.next;
        }
        while(pp.next != null){
            head = pp.next;
            pp.next = pp.next.next;
            pp = pp.next;
            head.next = pp.next;
            head = head.next;
        }
        return dummy.next;
    }
}