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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0, 0);
        
    }
    public int dfs(TreeNode root, int curSum, int sum){
        if (root == null) return sum;
        curSum = curSum*10 + root.val;
        if(root.left == null && root.right == null) {
            sum += curSum;
            return sum;
        }
        return dfs(root.left,curSum,sum) + dfs(root.right, curSum, sum);
    }
}