public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <=0 || k <= 0 || k > n) return res;
        List<Integer> curr = new ArrayList<>();
        combination(n,1,k, res, curr);
        return res;
    }
    
    public void combination(int n, int start, int k, List<List<Integer>> res, List<Integer> curr){
        if (k==0){
            List<Integer> temp = new ArrayList<>(curr);
            res.add(temp);
            return;
        }
        for (int i = start; i <= n-k+1; i++){
            curr.add(i);
            combination(n, i+1,k-1,res,curr);
            curr.remove(curr.size()-1);
        }
        
    }
}