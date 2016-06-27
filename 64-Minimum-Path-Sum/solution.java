public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m ==0 || n ==0) return 0;
        
        int[] dp = new int[m];
        dp[0]= grid[0][0];
        for(int i =1; i < m; i++){
            dp[i] = dp[i-1] + grid[i][0];
        }
        for (int j = 1; j < n; j++){
            dp[0] += grid[0][j];
            for(int i = 1; i < m; i++){
                dp[i] = Math.min(dp[i-1], dp[i]) +grid[i][j];
            }
        }
        return dp[m-1];
    }
}