public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long Dividend = Math.abs((long) dividend);
        long Divisor = Math.abs((long) divisor);
        
        int res = 0;
        
        while (Dividend >= Divisor){
            int shift = 0;
            while (Dividend >= (Divisor<<shift)){
                shift++;
            }
            res += 1<< (shift-1);
            
            Dividend -= Divisor << (shift-1);
        }
        
        if ((divisor > 0 && dividend >0) || (divisor < 0 && dividend < 0)) return res;
        else return -res;
    }
}