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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length, len1 = inorder.length;
        if (len != len1) return null;
        return buildTree(preorder, inorder, 0, 0, len-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (preStart > preorder.length -1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rIndex = -1;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == root.val) rIndex = i; 
        }
        root.left = buildTree(preorder, inorder, preStart+1, inStart, rIndex-1);
        root.right = buildTree(preorder, inorder, preStart + rIndex - inStart+1, rIndex+1, inEnd);
        return root;
    }
}