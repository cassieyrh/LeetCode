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
        TreeLinkNode leftmost = root;
        
        while (leftmost != null){
            root = leftmost;
            while (root != null && root.left == null && root.right == null){
                root = root.next;
            }
            if (root == null) return;
            leftmost = root.left!=null ? root.left: root.right;
            TreeLinkNode cur = leftmost;
            
            while (root != null){
                if (cur == root.left){
                    if(root.right != null){
                        cur.next = root.right;
                        cur = cur.next;
                    }
                    root = root.next;
                }else if (cur == root.right){
                    root = root.next;
                }else{
                    if (root.left == null && root.right == null){
                        root = root.next;
                        continue;
                    }
                        cur.next = root.left != null? root.left : root.right;
                        cur = cur.next;
                }
            }
            
            
        }
    }
}