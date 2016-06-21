public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int max = 0;
        while (i < j){
            int a = height[i], b = height[j];
            int h = Math.min(a,b);
            max = Math.max(max, h*(j-i));
                if (height[i] < height[j]){
                    i++;
                }else{
                    j--;
                }
        }
        return max;
    }
    
    
}