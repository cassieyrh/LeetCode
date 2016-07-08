public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }
    public int findPeak(int[] nums, int low, int high){
        if(low == high) return low;
        int mid = low + (high - low)/2;
        if (nums[mid] > nums[mid+1]) return findPeak(nums,low, mid);
        else return findPeak(nums, mid+1, high);
    }
    
}