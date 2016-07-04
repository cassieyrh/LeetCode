public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] total = new int[n];
        
        for (int i = 0; i< n; i++){
            total[i] = triangle.get(n-1).get(i);
        }
        for(int j = n-2; j >=0; j--){  //notice here: j<i
            for (int i = 0; i< j+1; i++){
                total[i]= triangle.get(j).get(i)+ Math.min(total[i],total[i+1]);
            }
        }
        return total[0];
    }
}