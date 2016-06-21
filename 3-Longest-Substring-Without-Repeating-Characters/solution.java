public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] array = s.toCharArray();
        int i = 0;
        int count = 0;
        
        while (i < s.length()){
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(array[i], i);
            int j = i+1;
            while (j< s.length() && !map.containsKey(array[j])){
                map.put(array[j], j);
                j++;
            }
            if (j-i > count) count = j-i;
            if (j == s.length()) j = j-1;
            i = map.get(array[j])+1;
        }
        return count;
    }
}