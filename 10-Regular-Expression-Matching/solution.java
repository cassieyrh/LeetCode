public class Solution {
    /*
    "ab" does not match with ".*" 
    */

    public boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        else{
            if(p.length() ==1 || p.charAt(1) != '*'){
                return s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
            }else{
                return isMatch(s, p.substring(2)) || s.length()!=0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
            }
        }
    }
    
}