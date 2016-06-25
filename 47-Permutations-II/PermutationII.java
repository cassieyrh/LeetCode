public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0 ) return res;
        
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteU(nums, res, curr,used);
        return res;
    }
    
    public void permuteU( int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] used){
        if (curr.size()==nums.length){
            List<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
        }
        
        for (int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            //skip when there is unused same nodes
            if (i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i] = true;
            curr.add(nums[i]);
            permuteU(nums, res, curr, used);
            curr.remove(curr.size()-1);
            used[i] = false;
            
        }
    }
}