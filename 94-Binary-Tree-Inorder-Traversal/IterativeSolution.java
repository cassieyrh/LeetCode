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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (cur != null || !stack.isEmpty()){
            if (cur == null){
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }else{
                stack.push(cur);
                cur = cur.left;
            }
            
        }
        return res;
    }
}