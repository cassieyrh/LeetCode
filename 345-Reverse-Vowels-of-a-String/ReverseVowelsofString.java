public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <=0) return s;
        
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int i = 0, j = s.length()-1;
        while(i<j){
            //indexOf ("Of" should be in upper case)
            if (vowels.indexOf(array[i]) == -1){
                i++;
                continue;
            }
            if (vowels.indexOf(array[j]) == -1){
                j--;
                continue;
            }
            
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            
            i++;
            j--;
        }
        return new String(array);
    }
}