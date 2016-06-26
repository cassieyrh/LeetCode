public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        
        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        int[] pos = {0,0};
        int m=1;
        int total = n*n;
        res[0][0] = 1;
        int r = 0;
        while (m < total){
            for (int i = 1; i < n; i++){
                pos[0] += direct[d][0];
                pos[1] += direct[d][1];
                res[pos[0]][pos[1]] = ++m;
            }
            if (r>0 && r%2==0) n--;
            r++;
            d = (d+1)%4;
        }
        return res;
    }
}