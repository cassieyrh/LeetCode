public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length()==0 || s.charAt(0)=='0') return 0;
        
        int dp1 = 1, dp2 = 1; // dp1: decode ways of s.substring(0,i), dp2: decode ways of s.substring(0, i-1)
        
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i)=='0') dp1 = 0;
            
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6'){
                dp1 = dp1 + dp2;
                dp2 = dp1-dp2;
            }else dp2 = dp1;
        }
        return dp1;
    }
}