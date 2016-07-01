public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s== null || s.length() < 4 || s.length() > 12) return res;
        List<String> curr = new ArrayList<>(); 
        dfs(s, curr,res, 0);
        return res;
    }
    
    public void dfs(String s, List<String> curr, List<String> res, int index){
        if (curr.size() == 4 && index == s.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(curr.get(0));
            for(int i = 1; i< 4; i++){
                sb.append('.');
                sb.append(curr.get(i));
            }
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < s.length() && i < index+3; i++){
            String ip = s.substring(index, i+1);
            if (isValid(ip)) {
                curr.add(ip);
                dfs(s, curr, res, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isValid(String ip){
        int len = ip.length();
        if (ip.charAt(0) == '0' && len>1) return false;
        if (Integer.parseInt(ip)>255) return false;
        return true;
    }
}