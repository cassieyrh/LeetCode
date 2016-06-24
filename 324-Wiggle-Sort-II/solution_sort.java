public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        //int[] copy = nums.clone();
        int n = nums.length;
        for (int i = 0; i<n; i++){
            nums[(2*i+1)%(n|1)]= copy[n-i-1];
        }
        }
}