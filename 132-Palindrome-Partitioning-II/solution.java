public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrom = new boolean[n][n];
        for(int i = n-1; i >=0; i--){
            for(int j = i; j < n; j++){
                if((j-i < 2 || isPalindrom[i+1][j-1]) && s.charAt(i) == s.charAt(j)){
                    isPalindrom[i][j] = true;
                }
            }
        }
        int[] dp = new int[n+1];
        dp[0] = -1;
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(isPalindrom[j][i-1])
                dp[i] = Math.min(dp[i], dp[j] +1);
            }
        }
        return dp[n];
    }
}