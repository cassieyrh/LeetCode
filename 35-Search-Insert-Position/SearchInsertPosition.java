public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        if (nums[0] >= target) return 0;
        int i = 0, j = nums.length;
        while (i<j){
            int mid = i+(j-i)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                i = mid+1;
            }
            else {
                j = mid;
            }
        }
        return i;
    }
}