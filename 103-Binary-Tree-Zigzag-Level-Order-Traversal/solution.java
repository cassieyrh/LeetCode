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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean flag = true;
        stack1.push(root);
        while(!stack1.isEmpty()){
            List<Integer> curLev = new ArrayList<>();
            while (!stack1.isEmpty()){
                TreeNode cur = stack1.pop();
                curLev.add(cur.val);
                    if (flag){
                        if (cur.left != null) stack2.add(cur.left);
                        if (cur.right != null) stack2.add(cur.right);
                    }else{
                        if (cur.right != null) stack2.add(cur.right);
                        if (cur.left != null) stack2.add(cur.left);
                    }
                }
            res.add(curLev);
            Stack<TreeNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
            flag = !flag;
        }
        return res;
    }
}