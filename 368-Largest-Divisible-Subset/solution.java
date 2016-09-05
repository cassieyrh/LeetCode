public class Solution {
    /*
    f[i] = max{f[j]} if i %j = 0;
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0, index = -1;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] +1){
                    dp[i] = dp[j] +1;
                    pre[i] = j;
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        while(index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        Collections.reverse(res);
        return res;
    }
}