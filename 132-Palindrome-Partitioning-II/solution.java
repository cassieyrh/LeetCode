public class Solution {
    public int minCut(String s) {
        int[] cut = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++) cut[i] = Integer.MAX_VALUE;
        cut[s.length()] = -1;
        for(int i = s.length()-1; i >=0; i--){
            for(int a = i, b = i; a >=0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) cut[a] = Math.min(cut[a], cut[b+1]+1);    //odd palindrome
            for(int a = i, b = i+1; a >=0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++) cut[a] = Math.min(cut[a], cut[b+1]+1);    //even palindrome
        }
        return cut[0];
    }
}