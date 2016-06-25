public class Solution {
    public void rotate(int[][] matrix) {
        //matrix[i][j] = matrix[n-1-j][i]
        int n = matrix.length;
        for (int i = 0; i < n/2; i++){
            int[] temp = matrix[i];
            matrix[i]= matrix[n-1-i];
            matrix[n-1-i]= temp;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j <i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}