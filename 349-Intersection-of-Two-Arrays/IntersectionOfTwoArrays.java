public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();
        
        for (int i = 0; i< nums1.length; i++){
            set.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])){
                intersect.add(nums2[i]);
            }
        }
        
        int[] res = new int[intersect.size()];
        int j = 0;
        //do not forget the type "int/Integer"
        for(int num: intersect){
            res[j++] = num;
        }
        return res;
    }
}