public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int size = 0;
        for (int i = 0; i < nums.length; i++){
            int index = 0;
            if (i > 0 && nums[i] == nums[i-1]) index = size;
            size = res.size();
            for (int j = index; j< size; j++){
                List<Integer> temp = new ArrayList(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}