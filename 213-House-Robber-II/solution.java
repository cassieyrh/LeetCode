public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robber(nums, 0, nums.length-2), robber(nums, 1, nums.length-1));
    }
    
    private int robber(int[] nums, int lo, int hi){
        int include = 0, exclude = 0;
        for(int j = lo; j<= hi; j++){
            int i = include, e=exclude;
            include = e + nums[j];
            exclude = Math.max(e,i);
        }
        return Math.max(include, exclude);
    }
}