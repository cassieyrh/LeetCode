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
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<>();
        return generate(1,n);
        
    }
    public List<TreeNode> generate(int min, int max){
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }
        List<TreeNode> left, right;
        for (int i = min; i<= max; i++){
            left = generate(min, i-1);
            right = generate(i+1, max);
            for (TreeNode ln: left){
                for (TreeNode rn: right){
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    res.add(root);
                }
            }
        }
        return res;
    }
}