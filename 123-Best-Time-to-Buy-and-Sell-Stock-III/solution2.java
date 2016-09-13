public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[] maxleft = new int[n];
        int minleft = prices[0], maxleftP = 0, maxright = prices[n-1], maxrightP = 0, maxP = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] < minleft) minleft = prices[i];
            else maxleftP = Math.max(maxleftP, prices[i] - minleft);
            maxleft[i] = maxleftP;
        }
        for(int i = n-2; i >=0; i--){
            if(prices[i] > maxright) maxright = prices[i];
            else maxrightP = Math.max(maxrightP, maxright - prices[i]);
            maxP = Math.max(maxrightP + maxleft[i], maxP);
        }
        return maxP;
    }
}