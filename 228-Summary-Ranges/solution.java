public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
        return res;
        
        int j = 0, min = nums[0];
        for(int i = 1; i< nums.length; i++){
            if (nums[i] != nums[i-1]+1){
                res.add(convertToString(min,nums[i-1]));
                j=i;
            }
            min = nums[j];
        }
        
        res.add(convertToString(min, nums[nums.length-1]));
        return res;
    }
    
    public String convertToString(int m, int n){
        if(m == n) return Integer.toString(m);
        return Integer.toString(m) + "->"+ Integer.toString(n);
    }
}