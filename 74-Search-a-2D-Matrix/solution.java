public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if ( target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int up = 0, down = m-1, left = 0, right = n-1;
        while(up <= down){
            int mid = up + (down-up)/2;
            int val = matrix[mid][0];
            if ( val > target){
                down = mid-1;
            }else if (val < target){
                up = mid+1;
            }else return true;
        }
        int row = up -1;
        
        while (left <= right){
            int mid = left + (right - left)/2;
            int val = matrix[row][mid];
            if(val > target){
                right = mid-1;
            }else if(val < target){
                left = mid+1;
            }else return true;
        }
        return false;
        
    }
}