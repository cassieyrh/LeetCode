public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] end = new int[nums.length];
        int size = 0;
        for(int n : nums){
            int low = 0, high = size;
            while(low < high){
                int mid = low + (high - low)/2 ;
                if(n > end[mid]) low = mid+1;
                else high = mid;
            }
            end[low] = n;
            if(low == size) size++;
        }
        return size;
    }
}