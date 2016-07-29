public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long low = 1, high = num;
        while(low < high){
            long mid = low+ (high-low)/2;
            long square = mid*mid;           //Should use long instead of int
            if(square > num){
                high = mid;
            }else if(square < num){
                low = mid+1;
            }else return true;
        }
        return false;
    }
}