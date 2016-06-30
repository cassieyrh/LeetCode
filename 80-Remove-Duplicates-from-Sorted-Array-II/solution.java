public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;
        
        int end = 1;
        for (int i =2; i < nums.length; i++){
            if (nums[i] != nums[end-1]){
                nums[++end] = nums[i];
            }
        }
        return end+1;
    }
}