public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        for(int i = len-1; i>=0; i--){
            for(int j = i; j< len; j++){
                if((j-i<2||isPal[i+1][j-1]) &&s.charAt(i)==s.charAt(j)){
                    isPal[i][j] = true;
                } 
            }
        }
        partition(s,0,res,cur,isPal);
        return res;
    }
    
    public void partition(String s, int start, List<List<String>> res, List<String> cur, boolean[][] isPal){
        if (start == s.length()){
            res.add(new ArrayList(cur));
            return;
        }
        for (int i = start; i < s.length();i++){
            if(isPal[start][i]){
                cur.add(s.substring(start,i+1));
                partition(s, i+1, res, cur, isPal);
                cur.remove(cur.size()-1);
            }
        }
    }
}