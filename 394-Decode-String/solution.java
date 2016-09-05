public class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int i = 0;
        while (i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int sum = 0;
                while(i< s.length() && Character.isDigit(s.charAt(i))){
                    int digit = s.charAt(i) - '0';
                    sum = sum*10 + digit;
                    i++;
                }
                numStack.push(sum);
            }
            else if(s.charAt(i) == '['){
                strStack.push(res);
                res = new StringBuilder();
                i++;
            }
            else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder(strStack.pop());
                int count = numStack.pop();
                for(int j = 0 ; j < count; j++){
                    temp.append(res);
                }
                res = temp;
                i++;
            }
            else{
                res.append(s.charAt(i++));
            }
        }
        return res.toString();
    }
}