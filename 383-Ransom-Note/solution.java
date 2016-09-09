public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        for(char c : m){
            arr[c -'a']++;
        }
        for(char c: r){
            if(--arr[c-'a'] < 0) return false;
        }
        return true;
    }
}