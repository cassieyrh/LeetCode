public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len1+1];
        for(int i = 0; i <= len1; i++) dp[i] = i;
        for(int j = 1; j <= len2; j++){
            int pre = dp[0];
            dp[0] = j;     //do not forget this line
            for(int i = 1; i <= len1; i++){
                int temp = dp[i];
                dp[i] = Math.min(Math.min(dp[i-1] +1, dp[i]+1), pre+score(word1.charAt(i-1), word2.charAt(j-1)));
                pre = temp;
            }
        }
        return dp[len1];
    }
    
    public int score(char cha1, char cha2){
        if(cha1 == cha2) return 0;
        else return 1;
    }
}