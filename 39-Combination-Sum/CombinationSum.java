public class Solution {
    //Depth first search
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if ( candidates == null || candidates.length == 0) return res;
        
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combSum(candidates, target, 0, res, curr);
        
        return res;
    }
    public void combSum(int[] candidates, int target, int j, List<List<Integer>> res, List<Integer> curr){
        if (target == 0){
            List<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
            return;
        }
        
        for (int i = j; i < candidates.length; i++){
            if (candidates[i] > target){
                return;
            }
            curr.add(candidates[i]);
            combSum(candidates, target - candidates[i], i, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}