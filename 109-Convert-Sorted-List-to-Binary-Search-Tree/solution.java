/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode  cur = new ListNode(0);
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 0;
        cur = head;
        ListNode p = head;
        while (p != null){
            p = p.next;
            size ++;
        }
        return generate(size);
    }
    
    
    
    public TreeNode generate(int n){
        if (n <= 0) return null;
        int mid = n/2;
        TreeNode left = generate(mid);
        TreeNode root = new TreeNode(0);
        root.val = cur.val;
        cur = cur.next;
        root.left = left;
        TreeNode right = generate(n-mid-1);
        root.right = right;
        return root;
    }
}