public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        Set<Integer> set = new HashSet<>();
        
        set.add(0);
        for(int n : nums){
            Set<Integer> temp = new HashSet<>();
            for(int m : set){
                if(m+n == target) return true;
                temp.add(m + n);
            }
            set.addAll(temp);
        }
        return set.contains(target);
    }
}