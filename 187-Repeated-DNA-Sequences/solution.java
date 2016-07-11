public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> found = new HashSet<>(), repeat = new HashSet<>();
        for (int i = 0; i < s.length()-9; i++){
            String sub = s.substring(i,i+10);//remember i+10 is exclusive
            if(!found.add(sub)){
                repeat.add(sub);
            }
        }
        return new ArrayList(repeat);
    }
}