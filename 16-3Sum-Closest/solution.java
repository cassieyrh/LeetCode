public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return Integer.MAX_VALUE;
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++){
            int j = i+1, k = nums.length-1; 
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = target - sum;
                if (Math.abs(diff)< Math.abs(mindiff)) mindiff = diff;
                if (diff == 0 ) return target;
                else if (diff > 0){
                    while (j+1<k && nums[j+1] == nums[j]) j++;
                    j++;
                }else {
                    while (k-1>j && nums[k-1] == nums[k]) k--;
                    k--;
                }
            }
        }
        return target - mindiff;
    }
}