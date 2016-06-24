public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        combSum(candidates, target, 0, res, curr);
        //res could have duplicated eliments
        HashSet<List<Integer>> set = new HashSet<>(res);
        res.clear();
        res.addAll(set);
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
            combSum(candidates, target - candidates[i], i+1, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}