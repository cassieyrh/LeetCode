public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        String[] snum = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            snum[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>(){
            //overwrite comparator method
            public int compare(String str1, String str2){ //returns a positive value if obj1 is greater than obj2.
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);// positive int if s2 > s1
            }
        };
        
        Arrays.sort(snum, comp);
        
        if (snum[0].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s: snum){
            sb.append(s);
        }
        return sb.toString();
        
    }
}