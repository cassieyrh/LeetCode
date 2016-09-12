public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int maxProfit = 0;
        int[] before = new int[3], after = new int[3], between = new int[2];
        int[] onetrans = findindex(prices, 0, prices.length);
        if(onetrans[1] - onetrans[0] > 1) {
            between = findbetween(prices, onetrans[0] + 1, onetrans[1]);
            maxProfit = Math.max(prices[between[0]] - prices[onetrans[0]] + prices[onetrans[1]] - prices[between[1]], maxProfit);
        }
        if(onetrans[0] > 1){
            before = findindex(prices, 0, onetrans[0]);
            maxProfit = Math.max(before[2] + onetrans[2], maxProfit);
        } 
        if(onetrans[1] < prices.length -2){
            after = findindex(prices, onetrans[1] + 1, prices.length);
            maxProfit = Math.max(after[2] + onetrans[2], maxProfit);
        } 
        return Math.max(maxProfit, onetrans[2]);
    }
    
    public int[] findindex(int[] prices, int start, int end){
        int[] res = new int[3];
        int min = prices[start], max = 0, low = 0;
        for(int i = start; i < end; i++){
            if(prices[i] <= min){
                min = prices[i];
                low = i;
            }
            int diff = prices[i] - min;
            if(diff > max){
                max = diff;
                res[0] = low;
                res[1] = i;
            }
        }
        res[2] = max;
        return res;
    }
    
    public int[] findbetween(int[] prices, int start, int end){
        int[] res = new int[2];
        int max = prices[start], maxdiff = 0, low = 0;
        for(int i = start; i < end; i++){
            if(prices[i] >= max){
                max = prices[i];
                low = i;
            }
            int diff = max - prices[i];
            if(diff > maxdiff){
                maxdiff = diff;
                res[0] = low;
                res[1] = i;
            }
        }
        return res;
    }
}