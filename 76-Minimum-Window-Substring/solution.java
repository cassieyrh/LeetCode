public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, 0);
        }
        for(char cha : t.toCharArray()){
            if(map.containsKey(cha)){
               map.put(cha, map.get(cha)+1); 
            } 
            else return "";
        }
        int start = 0, end = 0, head = 0, count = t.length(), minLen = Integer.MAX_VALUE;
        while(end < s.length()){
            char cur = s.charAt(end);
            if(map.get(cur) > 0) count--;
            map.put(cur, map.get(cur)-1);
            end++;
            
            while(count == 0){
                if(end-start < minLen){
                    minLen = end - start;
                    head = start;
                }
                char cur2 = s.charAt(start);
                map.put(cur2, map.get(cur2)+1);
                if(map.get(cur2) >0){
                    count++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head+minLen);
    }
}