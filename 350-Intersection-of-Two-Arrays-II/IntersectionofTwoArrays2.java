public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }else map.put(nums1[i], 1);
        }
        for (int j = 0; j < nums2.length; j++){
            if (!map.containsKey(nums2[j])){
                continue;
            }else{
                if (map.get(nums2[j]) > 0){
                    res.add(nums2[j]);
                    map.put(nums2[j], map.get(nums2[j]) -1);
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}