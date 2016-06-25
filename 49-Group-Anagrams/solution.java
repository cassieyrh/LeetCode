public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        if (strs == null || strs.length == 0) return res;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String str : strs){
            char[] string =str.toCharArray();
            Arrays.sort(string);
            String ns = new String(string);
            
            if (map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(ns, temp);
            }
        }
        res.addAll(map.values());
        return res;
    }
}