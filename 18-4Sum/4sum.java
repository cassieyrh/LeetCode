public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return res;
        //Sort the array first
        Arrays.sort(nums);
        
        for ( int i = 0; i < nums.length-3; i++){
            //Skip duplicated digits
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2;j++){
                //Skip duplicated digits
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                    int low = j+1, high = nums.length-1;
                    while (low < high){
                        int sum = nums[i]+nums[j]+nums[low]+nums[high];
                        if (sum == target){
                            res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                            while (low<high && nums[low+1]==nums[low]) low++;
                            while (high > low && nums[high-1]==nums[high]) high--;
                            low++;
                            high--;
                        }else if( sum < target) low++;
                        else high--;
                    }
            }
        }
        return res;
        }
}