public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < len-2; i++){
            int target = 0 - nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;    //do not forget this line to get rid of duplicates
            int low = i + 1, high = len-1;
            while(low < high){
                if(nums[low] + nums[high] == target){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] + nums[high] == target) low++;
                    while(high > low && nums[low] + nums[high] == target) high--;
                }else if(nums[low] + nums[high] < target){
                    low++;
                }else{
                    high--;
                }
            }
            
        }
        return res;
    }
}