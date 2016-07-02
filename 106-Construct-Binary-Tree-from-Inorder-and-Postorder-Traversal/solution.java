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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length, len1 = postorder.length;
        if (len != len1) return null;
        return buildTree(inorder, postorder, 0, len-1, len-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd){
        if (postEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rIndex = -1;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == root.val) rIndex = i;
        }
        root.left = buildTree(inorder, postorder, inStart, rIndex-1, postEnd+rIndex-inEnd-1);
        root.right = buildTree(inorder, postorder, rIndex+1, inEnd, postEnd-1);
        return root;
    }
}