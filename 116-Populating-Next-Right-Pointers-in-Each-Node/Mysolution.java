/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        connect (root.left, root.right);
        
    }
    public void connect(TreeLinkNode l, TreeLinkNode r){
        if (l == null || r == null) return;
        l.next = r;
        connect(l.left, l.right);
        connect(r.left, r.right);
        connect(l.right, r.left); //do not forget
    }
}