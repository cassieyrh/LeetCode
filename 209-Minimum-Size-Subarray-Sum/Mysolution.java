public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum =nums[0], ans = Integer.MAX_VALUE;
        while(j < nums.length){
            if (sum >= s){
                ans = Math.min(j-i+1,ans);
                if(i == nums.length) break;
                sum -= nums[i++];
            }else if(sum < s){
                if (j == nums.length-1) break;
                sum += nums[++j];
            }
        }
        return ans == Integer.MAX_VALUE? 0: ans;
    }
}