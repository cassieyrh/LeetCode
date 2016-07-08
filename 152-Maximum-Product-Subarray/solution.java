public class Solution {
    public int maxProduct(int[] nums) {
       int maxpre = nums[0], minpre = nums[0], max = nums[0], maxhere, minhere;
       for (int i = 1; i< nums.length; i++){
           maxhere = Math.max(Math.max(maxpre*nums[i], minpre*nums[i]),nums[i]);
           minhere = Math.min(Math.min(maxpre*nums[i], minpre*nums[i]),nums[i]);
           max = Math.max(maxhere, max);
           maxpre = maxhere;
           minpre = minhere;
       }
       return max;
    }
}