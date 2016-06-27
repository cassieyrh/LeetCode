public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        if (height == 0 || width == 0) return 0;
        
        //could reduce a little bit more space
        //int m = Math.min(height, width), n = Math.max(height, width); 
        int[] dp = new int[width];
        dp[0] = 1;
        for(int[] vec: obstacleGrid){
            for(int i =0; i<width;i++){
                if(vec[i]==1) dp[i] = 0;
                else if (i > 0) dp[i] += dp[i-1];
            }
        }
        return dp[width-1];
        
    }
}