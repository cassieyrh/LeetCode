public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);
        List<Integer> pre = triangle.get(0);
        
        for (int i = 1; i< n; i++){
            List<Integer> cur = new ArrayList<Integer>(triangle.get(i));
            //int len = i+1;
            cur.set(0, cur.get(0) + pre.get(0));
            for(int j = 1; j < i; j++){  //notice here: j<i
                cur.set(j, cur.get(j) + Math.min(pre.get(j-1),pre.get(j)));
            }
            cur.set(i, cur.get(i) + pre.get(i-1));
            pre = new ArrayList<Integer>(cur);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
             min= Math.min(min,pre.get(i));
        }
        return min;
    }
}