public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k+1; //Because this following code return the k th smallest number
        if (nums == null || nums.length < k) return -1;
        
        int pivot = nums[nums.length-1];
        int p = kthSelect(nums, k, 0, nums.length-1);
        return nums[p];
        
        }
    public int kthSelect(int[] nums, int k, int start, int end){
        int i = start, j = end, pivot = nums[end];
        while (i < j){
            if(nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap (nums, i, end);
        int x = i - start + 1;
        
        if (x == k) return i;
        else if ( x < k) return kthSelect(nums, k-x, i+1, end);
        else return kthSelect(nums, k, start, i-1);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j]= nums[i];
        nums[i]=temp;
    }

}