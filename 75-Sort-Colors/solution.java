public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <2) return;
        int low = 0, high = nums.length-1, i=0;
        while (i<=high){
            if (nums[i]==0){
                int temp = nums[low];
                nums[low] = 0;
                nums[i]=temp;
                i++; low++;
            }else if (nums[i] == 2){
                int temp = nums[high];
                nums[high]= 2;
                nums[i] = temp;
                high--;
            }else i++;
        }
    }
}