public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words[0].length();
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < n) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])) map.put(words[i], map.get(words[i])+1);
            else map.put(words[i], 1);
        }
        Map<String, Integer> curmap = new HashMap<>();
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int l = i, r = i; r + n <= s.length(); r += n){
                String cur = s.substring(r, r + n);
                if(map.containsKey(cur)){
                    curmap.put(cur, curmap.containsKey(cur)? curmap.get(cur) + 1 : 1);
                    if(curmap.get(cur) <= map.get(cur)) count++;
                    while(curmap.get(cur) > map.get(cur)){
                        String temp = s.substring(l, l + n);
                        curmap.put(temp, curmap.get(temp) - 1);
                        if(curmap.get(temp) < map.get(temp)) count--;
                        l += n;
                    }
                    if(count == words.length){
                        res.add(l);
                        String temp = s.substring(l, l + n);
                        curmap.put(temp, curmap.get(temp) - 1);
                        count--;
                        l += n;
                    }
                }else{
                    curmap.clear();
                    l = r + n;
                    count = 0;
                }
            }
            curmap.clear();
        }
        return res;
    }
}