public class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(n==1) return 1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i), 1);
            else map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        int res = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int v = entry.getValue();
            if(v % 2 == 0) res += v;
            else res += v - 1;
        }
        if(res < n) return res + 1;
        return res;
    }
}