public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        for ( int i = 0; i <n;i++ ){
            res.add(matrix[0][i]);
        }
        //res = new ArrayList<Integer> (Arrays.asList(matrix[0])); //add the first row
        
        int[][] direct = {{1,0},{0,-1},{-1,0},{0,1}};//direction array
        int d = 0;
        
        int[] pos = {0, n-1};
        int i = (m-1)*n;
        while (i >0){
            for (int j = 1; j < m; j++){
                pos[0] += direct[d][0];
                pos[1] += direct[d][1];
                res.add(matrix[pos[0]][pos[1]]);
                i--;
            }
            m--;
            int temp = m; m = n; n = temp;
            d = (d+1)%4; //change direction on the next round
        }
       return res; 
    }
}