public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            if(s.charAt(i) > '9' || s.charAt(i) < '0') return 0;
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2') return 0;
                dp[i] = i > 1 ?dp[i-2] : 1;
                if(i > 1) dp[i-1] = dp[i-2];
            } 
            else if (s.charAt(i) <= '6' && s.charAt(i) > '0' && s.charAt(i-1) == '2' || s.charAt(i-1) == '1'){
                dp[i] = dp[i-1] + (i > 1? dp[i-2] : 1);
            }else dp[i] = dp[i-1];
        }
        return dp[len-1];
    }
}