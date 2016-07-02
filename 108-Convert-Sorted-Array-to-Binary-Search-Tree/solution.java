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
    public TreeNode sortedArrayToBST(int[] nums) {
        int  n= nums.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(nums[n/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,n/2));//The ending index is exclusive
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,n/2+1,n));
        return root;
    }
}