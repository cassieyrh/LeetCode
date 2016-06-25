public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        
        int[] val = new int[n1.length()+n2.length()];
        
        for (int i = 0; i < n1.length(); i++){
            for (int j = 0; j < n2.length(); j++){
                val[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length; i++){
            int mod = val[i] % 10;
            int carry = val[i]/10;
            if (i+1 < val.length){
                val[i+1] += carry;
            }
            sb.insert(0,mod);
            
        }
        
        //Remove front extra 0 s
        while(sb.charAt(0) == '0' && sb.length()> 1){
        sb.deleteCharAt(0);
         }
        return sb.toString();
    }
}