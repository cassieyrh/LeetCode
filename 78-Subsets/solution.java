public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> temp = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>());
        for(int x: nums){
            int len = res.size();
            for (int j =0; j < len; j++){
                temp = new ArrayList<Integer>(res.get(j));
                temp.add(x);
                res.add(temp);
            }
        }
        return res;
    }
}