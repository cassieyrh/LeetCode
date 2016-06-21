public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        String[] roman = {"M", "CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,4,1};
        
        for ( int i = 0; i < 13; i++){
            if (num >= number[i]){
                int count = num/number[i];
                for (int j = 0; j < count; j++){
                    sb.append(roman[i]);
                }
                num %= number[i];
            }
        }
        return sb.toString();
    }
}