public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(res, "", n , n);
        return res;
    }
    
    public void dfs(ArrayList<String> res, String s, int left, int right){
        if (left > right) return;
        
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
        if (left >0) dfs(res, s +"(", left-1, right);
        if (right > 0) dfs(res, s + ")", left, right-1);
    }
}