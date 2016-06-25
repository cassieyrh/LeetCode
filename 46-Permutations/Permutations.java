public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        findPerm(nums, res, used, curr);
        return res;
    }
    public void findPerm(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> curr){
        if (curr.size()== nums.length){
            List<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
        }
        
        for (int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            findPerm(nums, res, used, curr);
            used[i]=false; //important to reset used after this recursion
            curr.remove(curr.size()-1);
        }
    }
}