public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int reach = 0, n = nums.length;
        for (int i = 0; i<n && i<=reach; i++){
            reach = Math.max(reach, i+nums[i]);
        }
        return reach >= n-1;
    }
}