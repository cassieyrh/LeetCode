public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)) continue;
            int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
            int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
            int len = left + right + 1;
            map.put(n, len);
            res = Math.max(res, len);
            map.put(n - left, len);
            map.put(n + right, len);
        }
        return res;
    }
}