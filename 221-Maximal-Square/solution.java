public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        int[] dp = new int[m+1];
        int maxsize = 0;
        for (int i = 1; i<= m; i++){
            dp[i] = 0;
        }
        int pre = 0;
        
        for(int j = 0; j< n; j++){
            for(int i = 1; i<=m; i++){
                int temp = dp[i];
                if(matrix[i-1][j] - '0' == 1){
                    dp[i] = Math.min(dp[i], Math.min(dp[i-1], pre))+1;
                    maxsize = Math.max(maxsize, dp[i]);
                }else dp[i] = 0;
                pre = temp;
            }
        }
        return maxsize*maxsize;
    }
}