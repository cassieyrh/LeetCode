public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);
        List<Integer> pre = triangle.get(0);
        
        for (int i = 1; i< n; i++){
            List<Integer> cur = new ArrayList<Integer>(triangle.get(i));
            int len = cur.size();
            for(int j = 1; j < i; j++){  //notice here: j<i
                cur.set(j, triangle.get(i).get(j) + Math.min(pre.get(j-1),pre.get(j)));
            }
            cur.set(0, triangle.get(i).get(0) + pre.get(0));
            cur.set(len-1, triangle.get(i).get(len-1) + pre.get(len-2));
            pre = new ArrayList<Integer>(cur);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < pre.size(); i++){
            if (pre.get(i)<min) min= pre.get(i);
        }
        return min;
    }
}