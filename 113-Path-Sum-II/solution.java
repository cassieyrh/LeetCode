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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(root, sum, res, cur);
        return res;
    }
    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur){
            if (root == null) return;
            cur.add(root.val); //root.val (but not root!)
            if (sum == root.val && root.left == null && root.right == null) {
                res.add(new ArrayList<Integer>(cur));
                //do not forgert to remove the last integer in the path even though we have found a path
                cur.remove(cur.size()-1);
                return;
            }else{
                dfs(root.left, sum-root.val, res, cur);
                dfs(root.right, sum-root.val, res, cur);
                cur.remove(cur.size()-1);
            }
    }
}