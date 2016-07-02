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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null){
            if (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode p = stack.pop();
                if (pre != null && pre.val >= p.val) return false;
                pre = p;
                cur = p.right;
            }
        } 
        return true;
    }
}