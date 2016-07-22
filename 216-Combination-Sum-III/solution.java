public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <=0 || k<=0) return res;
        ArrayList<Integer> curr = new ArrayList<>();
        findCombination(res, curr, n, k,1);
        return res;
    }
    
    private void findCombination(List<List<Integer>> res, ArrayList<Integer> curr, int target, int k, int digit){
        if(target < 0) return;
        
        if(target == 0 && curr.size()==k){
            ArrayList<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
        }
        
        for(int i = digit; i<=9; i++){
            curr.add(i);
            findCombination(res, curr, target-i, k, i+1);
            curr.remove(curr.size()-1);
        }
    }
}