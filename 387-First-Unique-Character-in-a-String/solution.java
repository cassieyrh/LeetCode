public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!map.containsKey(cur)){
                map.put(cur, i);
            }else{
                map.put(cur, Integer.MAX_VALUE);
            }
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            min = Math.min(entry.getValue(), min);
        }
        if(min != Integer.MAX_VALUE) return min;
        else return -1;
    }
}