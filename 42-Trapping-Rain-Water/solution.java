public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length -1;
        int maxL = 0, maxR = 0;
        int res = 0;
        while(left <= right){
            int heightL = height[left], heightR = height[right];
            if( heightL <= heightR){
                if(heightL >= maxL) maxL = heightL;
                else res += maxL - heightL;
                left ++;
            }else{
                if(heightR >= maxR) maxR = heightR;
                else res += maxR - heightR;
                right --;
            }
        }
        return res;
    }
}