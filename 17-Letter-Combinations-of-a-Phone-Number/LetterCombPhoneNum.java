public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] letters = {"","","abc", "def", "ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        char[] comb = new char[digits.length()];
        findcomb(digits, 0, letters, res, comb);
        return res;
    }
    
    public void findcomb(String digits, int index, String[] letters, List<String> res, char[] comb){
        
        if (index == digits.length()){
            res.add(new String(comb));
            return;
        }
        
        int dig = digits.charAt(index) - '0';
        for (char x: letters[dig].toCharArray()){
            comb[index] = x;
            findcomb(digits, index+1, letters, res,comb);
        }
    }
}