public class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        
        //f(n) = f(0)*f(n-1) + f(1)*f(n-2) +...f(n-1)*f(0);
        int[] nums = new int[n+1];
        nums[0] = 1; 
        for (int i = 1; i<=n; i++){
            for (int j = 0; j <i; j++){
                nums[i] += nums[j]*nums[i-j-1];
            }
        }
        return nums[n];
    }
}